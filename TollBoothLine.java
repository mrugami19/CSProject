
public class TollBoothLine {
	private boolean manual;
	private Vehicle[] veh;
	private int currentPos;
	private int waitTime;
	private final int MAXVEH=25;
	
	public TollBoothLine(boolean type){
		manual=type;
		veh = new Vehicle[MAXVEH];
		currentPos=0;
		waitTime=0;
		
	}
	
	public void setType(boolean type){
		manual=type;
	}
	public void addVehicles(Vehicle newVeh){
		veh[currentPos]=newVeh;
		currentPos++;
	}
	public void removeVehicles(){
		for(int i=0; i<currentPos;i++){
			
		}
		
	}

}
