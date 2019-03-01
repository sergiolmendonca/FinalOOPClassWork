package fellowships;

public abstract class Person {

	private String name;
	private Fellowship fellowship;
	private boolean dead;
	
	Person(String name){
		this.name = name;
		this.dead = false;
	}
	
	public boolean isDead() {
		return dead;
	}
	public Fellowship fellowship() {
		return this.fellowship;
	}

	public String name() {
		return name;
	}

	public void ame(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.name() == p.name();
	}

	public void setFellowship(Fellowship fellowship) {
		this.fellowship = fellowship;
	}
	
	public boolean isMemberOfAFellowship() {
		return this.fellowship != null ? true : false;
	}
	
	public boolean isMemberOfTheFellowship(Fellowship fellowship) {
		return this.isMemberOfAFellowship() ? this.fellowship.equals(fellowship) : false;
	}
	
	public void join(Fellowship fellowship) {
			fellowship.signUp(this);
	}

	public abstract String getRace();

	public void left() {
		this.fellowship.cancel(this);
		this.fellowship = null;
	}

	public void die() {
		this.left();
		this.dead = true;
	}

	public boolean isFellowOf(Person person) {
		return this.fellowship == person.fellowship();
	}

	public void fellow(Person person) {
		if(this.isMemberOfAFellowship()) {
			this.fellowship.signUp(person);
		}else if(person.isMemberOfAFellowship()) {
			person.fellowship().signUp(this);
		}
	}
	
}
