import java.io.*;
import java.util.*;
public class TollBoothLineSimulator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input File: ");
		File inputFile =  new File(sc.nextLine());
		Scanner scan = new Scanner(inputFile);
		System.out.print("Manual Toll Booths: ");
		int manualTB = sc.nextInt();
		System.out.print("Automatic Toll Booths: ");
		int automaticTB = sc.nextInt();
		
		TollBoothLine [] lines = new TollBoothLine[6];
		
		for(int i=0; i<manualTB; i++){
			TollBoothLine obj = new TollBoothLine(true);
			lines[i]= obj;
		}
		for(int j=manualTB; j<automaticTB; j++){
			TollBoothLine obj2 = new TollBoothLine(false);
			lines[j]= obj2;
		}
		
		

	}

}
