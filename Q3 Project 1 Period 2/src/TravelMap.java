
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TravelMap {
	
	
	public static void main(String[] args) {
		File maps = new File("easyMap1");
		
		try {
			Scanner r = new Scanner(maps);
			int row = r.nextInt();
			int column = r.nextInt();
			int rooms = r.nextInt();
			int x = 0;
			int y = 0;
			
			String[][][] map = new String[row][column][rooms];
			r.nextLine();
			for(int f = 0; f < map[0][0].length; f++) {
				for(int i = 0; i < map.length; i++) {
					String[] word = r.nextLine().split(" ");
					for(int j = 0; j < column; j++) {
						map[i][j][f] = word[j];
						if(word[j].equals("W")) {
							y = i;
							x = j;
						}
					}
				}
			}
			
			Stack<Integer> rows = new Stack<Integer>();
			Stack<Integer> columns = new Stack<Integer>();
			Stack<String> symbolFirst = new Stack<String>();
			Stack<Integer> traveledRows= new Stack<Integer>();
			Stack<Integer> traveledColumns = new Stack<Integer>();
			Stack<String> symbolVisited = new Stack<String>();
			boolean found = false;
			
			rows.push(y);
			columns.push(x);
			symbolFirst.push("W");
			traveledRows.push(y);
			traveledColumns.push(x);
			symbolVisited.push("W");
			for(int f = 0; f < rooms; f++) {
				while(found == false) {
					//This is for North
					if(rows.peek()-1 >= 0) {
						boolean getOut = false;
						for(int i = 0; i < symbolVisited.size(); i++) {
							if(rows.peek()-1 == traveledRows.get(i) && columns.peek() == traveledColumns.get(i)) {
								getOut = true;
								break;
							}
						}
						if(getOut == false) {
							rows.push(rows.peek()-1);
							columns.push(columns.peek());
							symbolFirst.push(map[rows.peek()][columns.peek()][f]);
							if(symbolFirst.peek().equals("$")) {
								traveledRows.push(rows.peek());
								traveledColumns.push(columns.peek());
								symbolVisited.push(symbolFirst.peek());
								break;
							}
						}
					}
					//This if for South
					if(rows.peek()+1 < row) {
						boolean getOut = false;
						for(int i = 0; i < symbolVisited.size(); i++) {
							if(rows.peek()+1 == traveledRows.get(i) && columns.peek() == traveledColumns.get(i)) {
								getOut = true;
								break;
							}
						}
						if(getOut == false) {
							rows.push(rows.peek()+1);
							columns.push(columns.peek());
							symbolFirst.push(map[rows.peek()][columns.peek()][f]);
							if(symbolFirst.peek().equals("$")) {
								traveledRows.push(rows.peek());
								traveledColumns.push(columns.peek());
								symbolVisited.push(symbolFirst.peek());
								break;
							}
						}
					}
					//This is for East
					if(columns.peek()+1 < column) {
						boolean getOut = false;
						for(int i = 0; i < symbolVisited.size(); i++) {
							if(rows.peek() == traveledRows.get(i) && columns.peek()+1 == traveledColumns.get(i)) {
								getOut = true;
								break;
							}
						}
						if(getOut == false) {
							rows.push(rows.peek());
							columns.push(columns.peek()+1);
							symbolFirst.push(map[rows.peek()][columns.peek()][f]);
							if(symbolFirst.peek().equals("$")) {
								traveledRows.push(rows.peek());
								traveledColumns.push(columns.peek());
								symbolVisited.push(symbolFirst.peek());
								break;
							}
						}
					}
					//This is for West
					if(columns.peek()-1 >= 0) {
						boolean getOut = false;
						for(int i = 0; i < symbolVisited.size(); i++) {
							if(rows.peek() == traveledRows.get(i) && columns.peek()-1 == traveledColumns.get(i)) {
								getOut = true;
								break;
							}
						}
						if(getOut == false) {
							rows.push(rows.peek());
							columns.push(columns.peek()-1);
							symbolFirst.push(map[rows.peek()][columns.peek()][f]);
							if(symbolFirst.peek().equals("$")) {
								traveledRows.push(rows.peek());
								traveledColumns.push(columns.peek());
								symbolVisited.push(symbolFirst.peek());
								break;
							}
						}
					}
					traveledRows.push(rows.peek());
					traveledColumns.push(columns.peek());
					symbolVisited.push(symbolFirst.peek());
				}
			}
			for(int i = 0; i < traveledRows.size(); i++) {
				map[traveledRows.get(i)][traveledColumns.get(i)][0] = "+";
			}
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < column; j++) {
					System.out.print(map[i][j][0]);
				}
				System.out.println();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
