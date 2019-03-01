package fellowships;

public class Hobbit extends Person {


	private String race = "Hobbit";

	Hobbit(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getRace() {
		return this.race  ;
	}

}
