
public class Cord {
	private int x;
	private int y;
	private String symbol;
	private Cord prev;
	private boolean visited;
	private int gCost;
	private int hCost;
	
	public Cord(int x, int y, String symbol) {
		this.x = x;
		this.y =y;
		this.symbol = symbol;
		visited = false;
		prev = null;
		gCost = 0;
		hCost = 0;
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
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getGCost() { 
		return gCost; 
	}
	public int getHCost() { 
		return hCost; 
	}
	public int getFCost() { 
		return gCost + hCost; 
	}
	public void setGCost(int gCost) {
		this.gCost = gCost; 
	}
	public void setHCost(int hCost) {
		this.hCost = hCost; 
	}
}
