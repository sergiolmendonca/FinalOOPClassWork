package myAPIs;

public class List<T> {
	private Object[] objects;

	public List() {

		this.objects = new Object[1];

	}

	// public methods

	public Object[] getObjects() {

		return this.objects;

	}

	public int count() {

		int countin = 0;

		for (Object o : this.objects) {

			if (o != null)
				countin++;

		}

		return countin;

	}

	public boolean isEmpty() {

		return this.count() == 0;

	}

	public Object get(int a) {

		if (this.length() <= a || a < 0)
			return null;

		return this.objects[a];

	}

	public boolean has(T o) {

		for (Object o1 : this.objects) {

			if (o1.equals(o))
				return true;

		}

		return false;

	}

	public void append(T o) {

		if (o != null) {

			if (this.objects[this.length() - 1] != null) {

				this.addIndex();

			}

			this.objects[this.length() - 1] = o;

		}

	}

	public void prepend(T o) {

		if (o != null) {

			this.moveRight();

			this.objects[0] = o;

		}

	}

	public void insert(T o, int index) {

		if (o != null && index < this.length() && index >= 0) {

			Object[] anotherObject = new Object[this.length() + 1];

			int aux = 0;

			for (int i = 0; i < anotherObject.length; i++) {

				if (i == index) {

					anotherObject[i] = o;

				} else {

					anotherObject[i] = this.objects[aux];

					aux++;

				}

			}

			this.objects = anotherObject;

		}

		if (index == this.length())
			append(o);

	}

	public boolean delete(int a) {

		if (this.length() <= a)
			return false;

		this.objects[a] = null;

		this.moveLeft();

		return true;

	}

	public boolean remove(T o) {

		if (this.has(o) == false)
			return false;

		for (int i = 0; i < this.length(); i++) {

			if (this.objects[i].equals(o))
				this.objects[i] = null;

		}

		this.moveLeft();

		return true;

	}

	public int indexOf(T o) {

		for (int i = 0; i < this.length(); i++) {

			if (this.objects[i].equals(o))
				return i;

		}

		return -1;

	}

	public void reset() {

		this.objects = new Object[1];

	}

	// private methods

	private void addIndex() {

		Object[] anotherObject = new Object[this.length() + 1];

		for (int i = 0; i < this.length(); i++) {

			anotherObject[i] = this.objects[i];

		}

		this.objects = anotherObject;

	}

	private void moveLeft() {

		Object[] o = new Object[this.length() - 1];

		int a = 0;

		for (int i = 0; i < o.length; i++) {

			if (this.objects[i] == null)
				a++;

			if (this.objects[a] != null) {

				o[i] = this.objects[a];

			}

			a++;

		}

		this.objects = o;

	}

	private void moveRight() {

		Object[] o = new Object[this.length() + 1];

		for (int i = this.length(); i > 0; i--) {

			o[i] = this.objects[i - 1];

		}

		this.objects = o;

	}
	
	public Object getLast() {
		return this.isEmpty() ? null : this.get(this.length()-1);
	}

	private int length() {

		return this.objects.length;

	}
}