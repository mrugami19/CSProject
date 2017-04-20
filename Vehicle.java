
public class Vehicle {
	private boolean manual;
	private int wheels;
	private int arrivalTime;
	private boolean done;
	
	public Vehicle(boolean type, int numWheels, int arrTime){
		manual=type;
		if(manual==true){
			wheels=numWheels;
		}
		else{
			wheels=0;
		}
		arrivalTime=arrTime;
		done=false;
	}
	public boolean getType(){
		return manual;
	}
	public int getWheels(){
		return wheels;
	}
	public int getArrivalTime(){
		return arrivalTime;
	}
	public boolean isDone(){
		return done;
	}
	public void done(){
		done=true;
	}
}
