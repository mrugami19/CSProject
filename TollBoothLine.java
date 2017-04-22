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
	
	
	public boolean insert(Vehicle insVeh)
	{
		boolean vehicleInserted = false;
		int lowestIndex =0;//Index of the line with the least number of cars
		int lowestLine = numItems[0]; //Assume that the first line has the least number of cars
		
		for(int i =0; i<numItems.length; i++)//Checks to see which line has the lowest amount of cars
		{
			if((numItems[i] < lowestLine))
			{
				lowestLine = numItems[i];
				lowestIndex = i;
				
			}
		}
		
		if(numItems[lowestIndex] < MAX_SIZE)// check if line with the least amount of vehicles has less then 25 cars
		{
			line[lowestIndex][currentPos[lowestIndex]] = insVeh;//if so, insert it there
			vehicleInserted = true;
			Vehicle.setLine(lowestIndex);//saves the line this car was inserted to into an attribute
			numItems[lowestIndex]++; //increase number of cars of that line
			currentPos[lowestIndex]++; //increase current position of that line	
			
			if( (numItems[lowestIndex]) == MAX_SIZE)//If the line is 25, then its full
			{
				isFull[lowestIndex] = true;
			}
		}
		System.out.println("Is full: " + isFull[lowestIndex]);
		
		return vehicleInserted;
	}
	
	public boolean remove(Vehicle remVeh)
	{
		boolean vehicleRemoved = false;
		
		return vehicleRemoved;
	}
	
	
	
	
}
	

