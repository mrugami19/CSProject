import java.util.*;
public class TollBoothLine 
{
	private final int MAX_SIZE = 25;
	private static int numLineAvailable = 6;
	private Vehicle line[][];
	private int numItems[];//how many items are in each line
	private int currentpos[];
	
	
	
	public TollBoothLine(int numLine)
	{
		if((numLine > 0) && ( (numLineAvailable - numLine)>=0 ))
		{
			line = new Vehicle[numLine][];
			numLineAvailable -= numLine;//decrease numLineAvailable
			for(int i =0; i < numLine; i++)//Initialize numItems to 0
			{
				numItems[i]=0;
			}
		}
		else 
			System.out.println("EXCEPTION");//ADD AN EXCEPTION LATER
				
	}
	 
	
	public boolean insert(Vehicle insVeh)
	{
		
	}
	
	public boolean remove(Vehicle remVeh)
	{
		
	}
	
	
	
}
	

