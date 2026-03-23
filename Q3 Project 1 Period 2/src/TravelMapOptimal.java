import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TravelMapOptimal {

    public static void main(String[] args) {
        File maps = new File("hardMap1");

        try {
        	long start = System.currentTimeMillis();
            Scanner r = new Scanner(maps);
            int row = r.nextInt();
            int column = r.nextInt();
            int rooms = r.nextInt();

            Cord[][][] map = new Cord[row][column][rooms];
            r.nextLine();
            for (int f = 0; f < rooms; f++) {
                for (int i = 0; i < row; i++) {
                    String[] word = r.nextLine().split(" ");
                    for (int j = 0; j < column; j++) {
                        map[i][j][f] = new Cord(j, i, word[j]);
                    }
                }
            }

            for (int f = 0; f < rooms; f++) {

                int startX = 0, startY = 0;
                int goalX = 0, goalY = 0;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        if (map[i][j][f].getSymbol().equals("W")) {
                            startY = i;
                            startX = j;
                        }
                        if (map[i][j][f].getSymbol().equals("|") || map[i][j][f].getSymbol().equals("$")) {
                            goalY = i;
                            goalX = j;
                        }
                    }
                }
                Queue<Cord> open = new PriorityQueue<>(Comparator.comparingInt(Cord::getFCost));

                map[startY][startX][f].setGCost(0);
                map[startY][startX][f].setHCost(Math.abs(startX - goalX) + Math.abs(startY - goalY));
                map[startY][startX][f].setVisit(true);
                open.offer(map[startY][startX][f]);

                boolean found = false;

                while (!open.isEmpty() && !found) {
                    Cord current = open.poll();
                    int cy = current.getY();
                    int cx = current.getX();

                    // direction arrays for North, South, East, West
                    int[] dy = {-1, 1, 0, 0};
                    int[] dx = {0, 0, 1, -1};

                    for (int i = 0; i < 4; i++) {
                        int ny = cy + dy[i];
                        int nx = cx + dx[i];

                        if (ny < 0 || ny >= row || nx < 0 || nx >= column) continue;

                        Cord neighbor = map[ny][nx][f];

                        if (neighbor.getVisit()) continue;

                        if (neighbor.getSymbol().equals("@")) continue;

                        // if we reached the goal
                        if (neighbor.getSymbol().equals("|") || neighbor.getSymbol().equals("$")) {
                            neighbor.setPrev(current);
                            found = true;
                            break;
                        }

                        if (neighbor.getSymbol().equals(".")) {
                            int newG = current.getGCost() + 1;
                            neighbor.setGCost(newG);
                            neighbor.setHCost(Math.abs(nx - goalX) + Math.abs(ny - goalY));
                            neighbor.setPrev(current);
                            neighbor.setVisit(true);
                            open.offer(neighbor);
                        }
                    }
                }

                Cord holder = map[goalY][goalX][f].getPrev();
                while (holder.getPrev() != null) {
                    map[holder.getY()][holder.getX()][f].setSymbol("+");
                    holder = holder.getPrev();
                }
            }

            for (int f = 0; f < rooms; f++) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(map[i][j][f].getSymbol() + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            long end = System.currentTimeMillis();
            long total = end-start;
            System.out.println("Time elapsed is " + total + " ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}