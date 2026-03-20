
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TravelMapQueue {
	
	
	public static void main(String[] args) {
		File maps = new File("easyMap1");
		
		try {
			Scanner r = new Scanner(maps);
			int row = r.nextInt();
			int column = r.nextInt();
			int rooms = r.nextInt();
			int x = 0;
			int y = 0;
			
			Cord[][][] map = new Cord[row][column][rooms];
			r.nextLine();
			for(int f = 0; f < map[0][0].length; f++) {
				for(int i = 0; i < map.length; i++) {
					String[] word = r.nextLine().split(" ");
					for(int j = 0; j < column; j++) {
						map[i][j][f] = new Cord(j, i, word[j]);
					}
				}
			}
			Queue<Integer> rows = new LinkedList<>();
			Queue<Integer> columns = new LinkedList<>();
			Queue<String> symbol = new LinkedList<>();

			
			for(int f = 0; f < rooms; f++) {
				for(int i = 0;;i++) {
					if(i == 0) {
						for(int j = 0; j < row; j++) {
							for(int k = 0; k < column; k++) {
								if(map[j][k][f].getSymbol().equals("W")) {
									rows.offer(y);
									columns.offer(x);
									symbol.offer("W");
									map[j][k][f].setVisit(true);
								}
							}
						}
					}
					//This is for North
					if(rows.peek()-1 >= 0 && map[rows.peek()-1][columns.peek()][f].getVisit() == false) {
						if(map[rows.peek()-1][columns.peek()][f].getSymbol().equals(".")) {
							map[rows.peek()-1][columns.peek()][f].setPrev(map[rows.peek()][columns.peek()][f]);
							map[rows.peek()-1][columns.peek()][f].setVisit(true);
							rows.offer(rows.peek()-1);
							columns.offer(columns.peek());
							symbol.offer(".");
							
						}
						else if(map[rows.peek()-1][columns.peek()][f].getSymbol().equals("$") || map[rows.peek()-1][columns.peek()][f].getSymbol().equals("|")) {
							map[rows.peek()-1][columns.peek()][f].setPrev(map[rows.peek()][columns.peek()][f]);
							rows.offer(rows.peek()-1);
							columns.offer(columns.peek());
							if(f == rooms-1) {
								symbol.offer("$");
							}
							else {
								symbol.offer("|");
							}
							break;
						}	
					}
					
					//This is for South
					if(rows.peek()+1 < row && map[rows.peek()+1][columns.peek()][f].getVisit() == false) {
						if(map[rows.peek()+1][columns.peek()][f].getSymbol().equals(".")) {
							map[rows.peek()+1][columns.peek()][f].setPrev(map[rows.peek()][columns.peek()][f]);
							map[rows.peek()+1][columns.peek()][f].setVisit(true);
							rows.offer(rows.peek()+1);
							columns.offer(columns.peek());
							symbol.offer(".");
							
						}
						else if(map[rows.peek()+1][columns.peek()][f].getSymbol().equals("$") || map[rows.peek()+1][columns.peek()][f].getSymbol().equals("|")) {
							map[rows.peek()+1][columns.peek()][f].setPrev(map[rows.peek()][columns.peek()][f]);
							rows.offer(rows.peek()+1);
							columns.offer(columns.peek());
							if(f == rooms-1) {
								symbol.offer("$");
							}
							else {
								symbol.offer("|");
							}
							break;
						}	
					}
					
					//This is for East
					if(columns.peek()+1 < column && map[rows.peek()][columns.peek()+1][f].getVisit() == false) {
						if(map[rows.peek()][columns.peek()+1][f].getSymbol().equals(".")) {
							map[rows.peek()][columns.peek()+1][f].setPrev(map[rows.peek()][columns.peek()][f]);
							map[rows.peek()][columns.peek()+1][f].setVisit(true);
							rows.offer(rows.peek());
							columns.offer(columns.peek()+1);
							symbol.offer(".");
							
						}
						else if(map[rows.peek()][columns.peek()+1][f].getSymbol().equals("$") || map[rows.peek()][columns.peek()+1][f].getSymbol().equals("|")) {
							map[rows.peek()][columns.peek()+1][f].setPrev(map[rows.peek()][columns.peek()][f]);
							rows.offer(rows.peek());
							columns.offer(columns.peek()+1);
							if(f == rooms-1) {
								symbol.offer("$");
							}
							else {
								symbol.offer("|");
							}
							break;
						}	
					}
					
					//This is for West
					if(columns.peek()-1 >= 0 && map[rows.peek()][columns.peek()-1][f].getVisit() == false) {
						if(map[rows.peek()][columns.peek()-1][f].getSymbol().equals(".")) {
							map[rows.peek()][columns.peek()-1][f].setPrev(map[rows.peek()][columns.peek()][f]);
							map[rows.peek()][columns.peek()-1][f].setVisit(true);
							rows.offer(rows.peek());
							columns.offer(columns.peek()-1);
							symbol.offer(".");
							
						}
						else if(map[rows.peek()][columns.peek()-1][f].getSymbol().equals("$") || map[rows.peek()][columns.peek()-1][f].getSymbol().equals("|")) {
							map[rows.peek()][columns.peek()-1][f].setPrev(map[rows.peek()][columns.peek()][f]);
							rows.offer(rows.peek());
							columns.offer(columns.peek()-1);
							if(f == rooms-1) {
								symbol.offer("$");
							}
							else {
								symbol.offer("|");
							}
							break;
						}	
					}
					rows.poll();
					columns.poll();
					symbol.poll();
				}
				rows.clear();
				columns.clear();
				symbol.clear();
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
