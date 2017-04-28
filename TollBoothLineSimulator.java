import java.util.*;
import java.io.*;

public class TollBoothLineSimulator
{
	
	public static void main(String[] args) throws IOException
	{
		//Initialize all variables
		boolean isManual = false;
		int shouldWemove;
		String inputFile;
		int tempArrivalTime=0;
		int numOfManual =0;
		int numOfAutomatic=0;
		String typeOfVeh="";
		int tempWheelTime=0;
		boolean canRead = true;
		String currentLine;
		int timer;
		StringTokenizer st;
		File file;
		Scanner scan;//this scan reads from file the first time
		Scanner scanFile;//this scan reads from file the second time
		Scanner scanKeyboard = new Scanner(System.in);

		//Statistics 
		int autoMaxWaitTime=0;
		int manMaxWaitTime=0;
		int autoTotalVeh=0;
		int manTotalVeh=0;
		int manTotalWaitTime=0;
		int autoTotalWaitTime=0;
		int waitTime=0;
		int []autoMaxLen;
		int[] manMaxLen;
		Vehicle currentVeh;
		//Asks for file
		System.out.print("Input File: ");
		inputFile = scanKeyboard.next();
		//Create file and Scanner
		file = new File(inputFile);
		scan = new Scanner(file);
		scanFile = new Scanner(file);
		//Makes sure the user enters at least one manual
		System.out.print("Manual Toll Booths: ");
		numOfManual = scanKeyboard.nextInt();
		while(numOfManual < 1)
		{
			System.out.println("ERROR...ENTER AT LEAST ONE FOR MANUAL");
			System.out.print("Manual Toll Booths: ");
			numOfManual = scanKeyboard.nextInt();
		}
		manMaxLen = new int[numOfManual];
		//Makes sure the user enters at least one automatic 
		System.out.print("Automatic Toll Booths: ");
		numOfAutomatic = scanKeyboard.nextInt();
		while(numOfAutomatic < 1)
		{
			System.out.println("ERROR...ENTER AT LEAST ONE FOR AUTOMATIC");
			System.out.print("Manual Toll Booths: ");
			numOfAutomatic = scanKeyboard.nextInt();
		}
		autoMaxLen = new int[numOfAutomatic];
		//Instantiates manual lines
		TollBoothLine manual = new TollBoothLine(numOfManual);
		//Instantiates automatic lines
		TollBoothLine automatic = new TollBoothLine(numOfAutomatic);
		//Scans the file to intialize timer	
		st = new StringTokenizer(scan.next(), ",");
		timer = Integer.parseInt(st.nextToken());
		scan.close();//closes scan because i'll use it again later
		//reads the file and instantiates vehicles
		while(scanFile.hasNext())
		{
			if(canRead)
			{
				currentLine = scanFile.nextLine();
				st = new StringTokenizer(currentLine, ",");
				while (st.hasMoreTokens())
				{
					tempArrivalTime = Integer.parseInt(st.nextToken());//arrivalTime
					typeOfVeh = st.nextToken();//is manual or auto?
					if(typeOfVeh.equals("M"))//if manual, read next line
					{
						tempWheelTime = Integer.parseInt(st.nextToken());
					}
				}
			}
			if(tempArrivalTime == timer)//if the current time matches this vehicle's time, insert it, else increment timer by 1
			{
				canRead = true; // will allow to san nextLine if canRead was false
				if(typeOfVeh.equals("M"))// if vehicle is manual make manual else make automatic
				{
					shouldWemove= manual.insert(new ManualVeh(tempArrivalTime, tempWheelTime));
					manTotalVeh++;
					isManual = true;
					if(shouldWemove >0)
					{
						if(manual.getNumItems(shouldWemove) > manMaxLen[shouldWemove])//checks for max lentgh
						{
							manMaxLen[shouldWemove] = manual.getNumItems(shouldWemove);
						}
					}
				}
				else
				{
					shouldWemove= automatic.insert(new AutomaticVeh(tempArrivalTime));
					autoTotalVeh++;
					if(shouldWemove > 0)
					{
						if(automatic.getNumItems(shouldWemove) > manMaxLen[shouldWemove])//checks for max lentgh
						{
							manMaxLen[shouldWemove] = automatic.getNumItems(shouldWemove);
						}
					}
				}
				if(isManual)//if its a manual move it up
				{
					if(shouldWemove >0)
					{
						currentVeh = manual.getVehicleInALine(shouldWemove, 0);
						if((currentVeh.getWheelTime()) + (currentVeh.getArrivalTime()) ==timer)
						{
							manual.moveUp(shouldWemove);
							waitTime = timer - currentVeh.getArrivalTime();
							manTotalWaitTime+= waitTime;
							if(manMaxWaitTime < waitTime)//Updates maxWaitTime
							{
								manMaxWaitTime = waitTime;
							}
						}
					}
				}
				else//else move automatic up
				{
					currentVeh = automatic.getVehicleInALine(shouldWemove, 0);
					if(shouldWemove >0)
					{
						if((currentVeh.getArrivalTime()) + 1 ==timer)
						{
							automatic.moveUp(shouldWemove);
							waitTime = timer - currentVeh.getArrivalTime();
							autoTotalWaitTime+= waitTime;
							if(autoMaxWaitTime < waitTime)
							{
								autoMaxWaitTime = waitTime;
							}
						}
					}
				}
			}
			else
			{
				timer++;
				canRead= false; //Will prevent from scanning next vehicle unless this current Vehicle is inserted
			}
		}
		
		//The next 4 lines of code is just to check if everything is being inserted in correct line
		// System.out.println("MANUAL:\n\n\n\n");
		// System.out.println(manual.toString());
		// System.out.println("Automatic: ");
		// System.out.println(automatic.toString());

		//Return MaxLen for manual
		System.out.println();
		for(int i =0; i < numOfManual; i++)
		{
			System.out.println("Manual Line #" + (i +1) + " Maximum Length=" + manMaxLen[i]);
		}
		//Return MaxLen for automaticfor(int i =0; i < numOfManual; i++)
		for(int i =0; i < numOfAutomatic; i++)
		{
			System.out.println("Automatic Line #" + (i +1) + " Maximum Length=" + autoMaxLen[i]);
		}

		System.out.println("Max Manual Wait = " + manMaxWaitTime);
		System.out.println("Max Automatic Wait = " + autoMaxWaitTime);
		System.out.println("Avg Manual Wait = " + ((double)manTotalWaitTime/manTotalVeh));
		System.out.println("Avg Auto Wait = " + ((double)autoTotalWaitTime/autoTotalVeh));
		}
}
