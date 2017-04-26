import java.util.*;
public class TollBoothLine 
{
	private final int MAX_SIZE = 25;
	private static int numLineAvailable = 6;
	private Vehicle line[][];
	private int numItems[];//how many items are in each line
	private int currentPos[];
	private boolean isFull[];
	
	public TollBoothLine(int numLine)
	{
		if((numLine > 0) && ( (numLineAvailable - numLine)>=0 ))
		{
			line = new Vehicle[numLine][MAX_SIZE];
			numLineAvailable -= numLine;//decrease numLineAvailable
			
			numItems = new int [numLine];
			for(int i =0; i < numLine; i++)//Initialize numItems to 0
			{
				numItems[i]=0;
			}
			
			currentPos = new int [numLine];
			for(int i =0; i < numLine; i++)//Initialize currentPos to 0
			{
				currentPos[i]=0;
			}
			
			isFull = new boolean[numLine];
			for(int i=0; i < numLine; i++)//Initialize isFull to false at first
			{
				isFull[i] = false;
			}
		}
		else 
			System.out.println("EXCEPTION");//ADD AN EXCEPTION LATER
				
	}
	
	public int insert(Vehicle insVeh)
	{
		boolean vehicleInserted = false;
		int lowestIndex =0;//Index of the line with the least number of cars--first
		int lowestLine = numItems[0]; //Assume that the first line has the least number of cars
		
		for(int i =0; i<numItems.length; i++)//Checks to see which line has the lowest amount of cars
		{
			if((numItems[i] < lowestLine))
			{
				lowestLine = numItems[i];
				lowestIndex = i;
				
			}
		}
		
		if(!isFull[lowestIndex])// check if line with the least amount of vehicles has less then 25 cars
		{
			line[lowestIndex][currentPos[lowestIndex]] = insVeh;//if so, insert it there
			vehicleInserted = true;
			//Vehicle.setLine(lowestIndex);//saves the line this car was inserted to into an attribute
			numItems[lowestIndex]++; //increase number of cars of that line
			currentPos[lowestIndex]++; //increase current position of that line	
			
			if( (numItems[lowestIndex]) == MAX_SIZE)//If the line is 25, then its full
			{
				isFull[lowestIndex] = true;
			}
			// System.out.println(isFull[lowestIndex]);
			
		}
		if(!vehicleInserted)
			return -1;
		else
			return lowestIndex; // returns the line this variable was saved into	
	}
	
	public void moveUp(int whichLine)//Moves the line up one, and deletes the first car
	{
		
		doneVehicle.insert(line[whichLine][0]);
		for(int i =0; i < currentPos[whichLine]-1;i++)
		{
			line[whichLine][i] = line[whichLine][i+1];
		}
		currentPos[whichLine]--;
		numItems[whichLine]--;
		if( (numItems[whichLine]) < MAX_SIZE)//If the line is 25, then its full
		{
			isFull[whichLine] = false;
		}
	
	}
	
	public String toString()
	{
		String temp = "";
		for(int i=0; i < line.length; i++)
		{
			
			for(int j =0; j < line[i].length; j++)
			{
				temp += line[i][j] + " ";
			}
			temp += "\n";
		}
		return temp;
	}

	public Vehicle getNextItem(int whichLine)
	{
		return line[whichLine][currentPos[whichLine]];
	}
	
	public Vehicle getLastItem(int whichLine)
	{
		return line[whichLine][currentPos[whichLine]-1];
	}
	
	public int isThere(Vehicle checkVeh)
	{
		for(int i=0; i < line.length; i++)
		{
			
			for(int j =0; j < line[i].length; j++)
			{
				if(checkVeh == line[i][j])
				{
					return i;
				}
			}
			
		}
		return -1;
	}
	// get max length and is there added for the main
	public int getMaxLength(int whichLine)
	{
		if (numItems[whichLine]>maximumLength) maximumLength= numItems[whichLine];
		return maximumLength;
	}
	
	public int isThere(Vehicle checkVeh)
	{
		for(int i=0; i < line.length; i++)
		{
			
			for(int j =0; j < line[i].length; j++)
			{
				if(checkVeh == line[i][j])
				{
					return i;
				}
			}
			
		}
		return -1;
	}
}
	

