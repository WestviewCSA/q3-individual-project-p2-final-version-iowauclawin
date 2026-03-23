
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TravelMapStack {
	public static void main(String[] args) {
		File maps = new File("mediumMap1");
		
		try {
			Long start = System.currentTimeMillis();
			Scanner r = new Scanner(maps);
			int row = r.nextInt();
			int column = r.nextInt();
			int rooms = r.nextInt();
			
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
			Stack<Integer> rows = new Stack<>();
			Stack<Integer> columns = new Stack<>();
			Stack<String> symbol = new Stack<>();

			
			for(int f = 0; f < rooms; f++) {
				for(int i = 0;;i++) {
					if(i == 0) {
						for(int j = 0; j < row; j++) {
							for(int k = 0; k < column; k++) {
								if(map[j][k][f].getSymbol().equals("W")) {
									rows.push(j);
									columns.push(k);
									symbol.push("W");
									map[j][k][f].setVisit(true);
									System.out.println(j + " " + k);
								}
							}
						}
					}
					
					int holderX = columns.peek();
					int holderY = rows.peek();
					
					rows.pop();
					columns.pop();
					symbol.pop();
					
					//This is for North
					if(holderY-1 >= 0 && map[holderY-1][holderX][f].getVisit() == false) {
						if(map[holderY-1][holderX][f].getSymbol().equals(".")) {
							map[holderY-1][holderX][f].setPrev(map[holderY][holderX][f]);
							map[holderY-1][holderX][f].setVisit(true);
							rows.push(holderY-1);
							columns.push(holderX);
							symbol.push(".");
							
						}
						else if(map[holderY-1][holderX][f].getSymbol().equals("$") || map[holderY-1][holderX][f].getSymbol().equals("|")) {
							map[holderY-1][holderX][f].setPrev(map[holderY][holderX][f]);
							rows.push(holderY-1);
							columns.push(holderX);
							if(f == rooms-1) {
								symbol.push("$");
							}
							else {
								symbol.push("|");
							}
							break;
						}	
					}
					
					//This is for South
					if(holderY+1 < row && map[holderY+1][holderX][f].getVisit() == false) {
						if(map[holderY+1][holderX][f].getSymbol().equals(".")) {
							map[holderY+1][holderX][f].setPrev(map[holderY][holderX][f]);
							map[holderY+1][holderX][f].setVisit(true);
							rows.push(holderY+1);
							columns.push(holderX);
							symbol.push(".");
							
						}
						else if(map[holderY+1][holderX][f].getSymbol().equals("$") || map[holderY+1][holderX][f].getSymbol().equals("|")) {
							map[holderY+1][holderX][f].setPrev(map[holderY][holderX][f]);
							rows.push(holderY+1);
							columns.push(holderX);
							if(f == rooms-1) {
								symbol.push("$");
							}
							else {
								symbol.push("|");
							}
							break;
						}	
					}
					
					//This is for East
					if(holderX+1 < column && map[holderY][holderX+1][f].getVisit() == false) {
						if(map[holderY][holderX+1][f].getSymbol().equals(".")) {
							map[holderY][holderX+1][f].setPrev(map[holderY][holderX][f]);
							map[holderY][holderX+1][f].setVisit(true);
							rows.push(holderY);
							columns.push(holderX+1);
							symbol.push(".");
							
						}
						else if(map[holderY][holderX+1][f].getSymbol().equals("$") || map[holderY][holderX+1][f].getSymbol().equals("|")) {
							map[holderY][holderX+1][f].setPrev(map[holderY][holderX][f]);
							rows.push(holderY);
							columns.push(holderX+1);
							if(f == rooms-1) {
								symbol.push("$");
							}
							else {
								symbol.push("|");
							}
							break;
						}	
					}
					
					//This is for West
					if(holderX-1 >= 0 && map[holderY][holderX-1][f].getVisit() == false) {
						if(map[holderY][holderX-1][f].getSymbol().equals(".")) {
							map[holderY][holderX-1][f].setPrev(map[holderY][holderX][f]);
							map[holderY][holderX-1][f].setVisit(true);
							rows.push(holderY);
							columns.push(holderX-1);
							symbol.push(".");
							
						}
						else if(map[holderY][holderX-1][f].getSymbol().equals("$") || map[holderY][holderX-1][f].getSymbol().equals("|")) {
							map[holderY][holderX-1][f].setPrev(map[holderY][holderX][f]);
							rows.push(holderY);
							columns.push(holderX-1);
							if(f == rooms-1) {
								symbol.push("$");
							}
							else {
								symbol.push("|");
							}
							break;
						}	
					}
					
				}
				rows.clear();
				columns.clear();
				symbol.clear();
				int finalX = 0;
				int finalY = 0;
				for(int j = 0; j < row; j++) {
					for(int k = 0; k < column; k++) {
						if(map[j][k][f].getSymbol().equals("|") || map[j][k][f].getSymbol().equals("$")) {
							finalX = k;
							finalY = j;
						}
					}
				}
				Cord holder = map[finalY][finalX][f].getPrev();
				while(holder.getPrev() != null) {
					map[holder.getY()][holder.getX()][f].setSymbol("+");
					holder = holder.getPrev();
				}
				
			}
			
			for(int f = 0; f < rooms; f++) {
				for(int i = 0; i < row; i++) {
					for(int j = 0; j < column; j++) {
						System.out.print(map[i][j][f].getSymbol());
					}
					System.out.println();
				}
			}
			long end = System.currentTimeMillis();
            long total = end-start;
            System.out.println("Time elapsed is " + total + " ms");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
