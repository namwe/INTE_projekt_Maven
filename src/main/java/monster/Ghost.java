package monster;

public class Ghost extends Monster {
	
	private boolean invisible;
	private int age;
	private final static int MAXAGE = 10000; 
	private final static int MAXSTRENGTH = 70; 
	
	public Ghost(int age) {	
		super((age > 100) ? MAXSTRENGTH : 50, 60, 20);
		this.age = age;
		if (this.age < 0 || this.age > MAXAGE) 
			throw new IllegalArgumentException("Age " + this.age + " not allowed "); 
	}
		

	
	public boolean isInvisible(){
	return invisible;	
	}
	
	public void toggleVisibility(){
		if(!invisible)
			invisible = true;
		else {
			invisible = false;
		}
	}
	
	public String invisibleToString() {
		if(invisible)
			return "invisible";
			else {
				return "visible";
			}
	}
	
	
	public String toString() {
		return super.toString() + " " + invisibleToString(); 
		
	}


	

}
