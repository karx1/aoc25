import java.util.ArrayList;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        ArrayList<String> grid = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            grid.add(scanner.nextLine());
        }

        int res = 0;
        int[][] dirs = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                char c = get(i, j, grid);
                if (c == '@') {
                    int num = 0;

                    for (int[] dir : dirs) {
                        Character other = get(i + dir[0], j + dir[1], grid);
                        if (other != null && ((char) other) == '@') num++;
                    }

                    if (num < 4) res++;
                }
            }
        }

        System.out.println(res);
        scanner.close();
    }

    public static Character get(int i, int j, ArrayList<String> grid) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid.get(0).length()) {
            return null;
        }

        return grid.get(i).charAt(j);
    }
}
