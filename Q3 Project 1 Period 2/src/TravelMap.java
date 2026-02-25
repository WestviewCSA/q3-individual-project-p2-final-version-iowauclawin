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
			String[][] map = new String[row*rooms][column];
			r.nextLine();
			for(int i = 0; i < map.length; i++) {
				String[] word = r.nextLine().split(" ");
				for(int j = 0; j < column; j++) {
					map[i][j] = word[j];
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
