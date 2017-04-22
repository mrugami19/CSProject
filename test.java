
public class test 
{
	public static void main(String[] args)
	{
		int numOfManual = 6;
//		int numOfAuto = 2;
		TollBoothLine manual = new TollBoothLine(numOfManual);
//		TollBoothLine automatic = new TollBoothLine(numOfAuto);
		
		
		//Tests if vehicle is inserted into the right pos
//		Vehicle v1 = new Vehicle();
//		System.out.println(manual.insert(v1));
//		
		
		//Test that it doesn't add a car in a full line
		for(int i =0; i < 150; i++)
		{
			manual.insert(new Vehicle());
		}
		
	}
}
