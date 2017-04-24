
public class Manual extends Vehicle{
	public Manual(boolean type, int numWheels, int arrTime){
		super(type,numWheels,arrTime);
	}
	public int getWheelTime(){
		
		return -1;
	}
	public String toString(){
		return super.toString() + " and the wheel time is " + getWheelTime();
	}
}
