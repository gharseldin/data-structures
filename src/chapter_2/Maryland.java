package chapter_2;

public class Maryland extends State {
	Maryland() {
	}

	public void printMe() {
		System.out.println("Read it.");
	}

	public static void main(String[] args) {
		Region east = new State();
		State md = new Maryland();
		Object obj = new Place();
		Place usa = new Region();
		md.printMe();				// Read it.
		east.printMe();				// Ship it.
		((Place) obj).printMe();	// Buy it.
		obj = md;
		((Maryland) obj).printMe(); // Read it.
		obj = usa;
		((Place) obj).printMe();	// Box it.
		usa = md;
		((Place) usa).printMe();	// Read it.
	}
}

class State extends Region {
	State() {
	}

	public void printMe() {
		System.out.println("Ship it.");
	}
}

class Region extends Place {
	Region() {
	}

	public void printMe() {
		System.out.println("Box it.");
	}
}

class Place extends Object {
	Place() {
	}

	public void printMe() {
		System.out.println("Buy it.");
	}
}