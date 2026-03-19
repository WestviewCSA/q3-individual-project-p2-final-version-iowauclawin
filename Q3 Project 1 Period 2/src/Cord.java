
public class Cord {
	private int x;
	private int y;
	private String symbol;
	private Cord prev;
	private boolean visited;
	
	public Cord(int x, int y, String symbol) {
		this.x = x;
		this.y =y;
		this.symbol = symbol;
		visited = false;
		prev = null;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getSymbol() {
		return symbol;
	}
	public Cord getPrev() {
		return prev;
	}
	public boolean getVisit() {
		return visited;
	}
	public void setPrev(Cord prev) {
		this.prev = prev;
	}
	public void setVisit(boolean visited) {
		this.visited = visited;
	}
}
