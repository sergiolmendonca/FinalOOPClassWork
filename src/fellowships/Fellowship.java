package fellowships;

import myAPIs.List;

public class Fellowship {

	private String name;
	private List<Member> list = new List<Member>();

	public Fellowship(String name) {
		this.name = "Fellowship " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int count() {
		return list.count();
	}

	public boolean hasNoMembers() {
		return list.isEmpty();
	}

	public boolean hasMembers() {
		return !list.isEmpty();
	}

	@Override
	public String toString() {
		return name;
	}

	public Member member(int i) {
		return (Member) list.get(i - 1);
	}

	public Member lastMember() {
		return (Member) list.getLast();
	}

	public void signUp(Person p1, Person p2, Person p3) {
		signUp(p1);
		signUp(p2);
		signUp(p3);
	}

	public void signUp(Person p1, Person p2) {
		signUp(p1);
		signUp(p2);
	}

	public void signUp(Person person) {
		if (!person.isMemberOfAFellowship() && !person.isDead()) {
			person.setFellowship(this);
			Member m = new Member(person);
			list.append(m);
		}
	}

	public int count(String race) {
		int count = 0;
		Object members[] = this.list.getObjects();

		for (Object obj : members) {
			Member member = (Member) obj;
			if (member.person().getRace().equals(race)) {
				count++;
			}
		}

		return count;
	}

	public boolean has(String race) {
		return this.count(race) > 0;
	}

	public void cancel(Person person) {
		Object members[] = this.list.getObjects();

		for (Object obj : members) {
			Member member = (Member) obj;
			if (member.person().equals(person)) {
				list.remove(member);
				person.setFellowship(null);
			}
		}
	}

	public void dissolve() {
		Object members[] = this.list.getObjects();

		for (Object obj : members) {
			Member member = (Member) obj;
			member.person().setFellowship(null);
			list.remove(member);
		}
	}

}
