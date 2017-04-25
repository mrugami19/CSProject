
public class Automatic extends Vehicle{
	public Automatic(boolean type, int numWheels, int arrTime){
		super(type,numWheels,arrTime);
	}
	public String toString(){
		return super.toString() + super.getWheels();
	}
}
