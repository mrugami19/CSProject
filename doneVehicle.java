import java.util.*;
public class doneVehicle 
{
	static ArrayList<Vehicle> doneVehicles = new ArrayList<Vehicle>();
	
	public static void insert(Vehicle insVeh)
	{
		doneVehicles.add(insVeh);
	}
	
	public static Vehicle getItem(int i)
	{
		if(i >= 0)
		{
			return doneVehicles.get(i);
		}
		else return null;
	}
}
