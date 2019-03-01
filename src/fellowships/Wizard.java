package fellowships;

public class Wizard extends Person {


	private String race = "Wizard";

	Wizard(String name) {
		super(name);
	}

	@Override
	public String getRace() {
		return this.race  ;
	}

}
