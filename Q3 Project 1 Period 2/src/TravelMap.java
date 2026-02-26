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
			
			String[][] map = new String[row*rooms][column];
			r.nextLine();
			for(int i = 0; i < map.length; i++) {
				String[] word = r.nextLine().split(" ");
				for(int j = 0; j < column; j++) {
					map[i][j] = word[j];
					if(map[i][j].equals("W")) {
						x = i;
						y = j;
					}
				}
			}
			Stack<Integer> rows = new Stack<Integer>();
			Stack<Integer> columns = new Stack<Integer>();
			Stack<String> symbolFirst = new Stack<String>();
			Stack<Integer> traveledRows= new Stack<Integer>();
			Stack<Integer> traveledColumns = new Stack<Integer>();
			Stack<String> symbolVisited = new Stack<String>();
			
			for(int i = 0; i < row*column; i++) {
				if(x==0) {
					rows.push(x);
					columns.push(y);
					symbolFirst.push("W");
					continue;
				}
				if(rows.peek()-1 >= 0) {
					boolean getOut = false;
					for(int j = 0; j < rows.size(); j++) {
						if(rows.peek()-1 == rows.get(j) && columns.peek() == columns.get(j)) {
							getOut = true;
							break;
						}
					}
					if(getOut) {
						break;
					}
					rows.push(rows.peek()-1);
					columns.push(columns.peek());
					symbolFirst.push(map[rows.peek()][columns.peek()]);
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
