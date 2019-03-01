package fellowships;

public class Dwarf extends Person {

	private String race = "Dwarf";

	Dwarf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getRace() {
		return this.race  ;
	}

}
