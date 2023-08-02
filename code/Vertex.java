
public class Vertex implements Comparable<Vertex>{

	/*
	 * symbol and address
	 */
	
	private char sym;
	private String add;
	
	public Vertex(char sym, String add) {
		this.sym = sym;
		this.add = add;
	}
	
	public char getSymbol() {
		return sym;
	}
	
	public String getAddress() {
		return add;
	}
	
	public String toString() {
		return "" + sym + ", " + add;
	}

	@Override
	public int compareTo(Vertex o) {
		
		return this.sym - o.sym;
	}
}
