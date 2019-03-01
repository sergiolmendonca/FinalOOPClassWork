package fellowships;

public class Human extends Person{


	private String race = "Human";

	Human(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getRace() {
		return this.race ;
	}
	
	

}
