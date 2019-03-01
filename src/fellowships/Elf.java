package fellowships;

public class Elf extends Person {


	private String race = "Elf";

	Elf(String name) {
		super(name);
	}
	
	@Override
	public String getRace() {
		return this.race  ;
	}


}
