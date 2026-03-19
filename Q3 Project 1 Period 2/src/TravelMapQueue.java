
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
						if(word[j].equals("W")) {
							y = i;
							x = j;
						}
					}
				}
			}
			Queue<Integer> rows = new LinkedList<>();
			Queue<Integer> columns = new LinkedList<>();
			Queue<String> symbol = new LinkedList<>();
			
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
