package Monster;

public class Ghost extends Monster {
	
	private boolean invisible; 
	
	
	public Ghost() {	
		super((new TimeOfDay().getTimeOfDay())? 10 : 2, 10, 10 , Habitat.FOREST, Habitat.LAND);
	}
	
	
	
	public boolean isInvisible(){
	return invisible;	
	}
	
	public boolean makeInvisible(){
		return invisible = true;	
		}
	
	public boolean makeVisible(){
		return invisible = false;	
		}
	
	public String toString() {
		return super.toString() + " " + invisible; 
		
	}

}
