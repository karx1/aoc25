import java.io.IOException;
import java.util.Scanner;

public class One {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int dial = 50;
        int res = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char direction = line.charAt(0);
            int sign = direction == 'L' ? -1 : 1;
            int dist = Integer.parseInt(line.substring(1));

            for (int i = 0; i < dist; i++) {
                dial += sign;
                dial += 100;
                dial %= 100;
                if (dial == 0) res++;
                // System.out.println(dial);
            }
        }

        System.out.println(res);
        scanner.close();
    }
}
