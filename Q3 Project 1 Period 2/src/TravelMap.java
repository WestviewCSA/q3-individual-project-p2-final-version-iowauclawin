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
			for(int i = 0; i < map.length; i++) {
				String word = r.next();
				for(int j = 0; j < column; j++) {
					map[i][j] = word.substring(j,j+1);
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
