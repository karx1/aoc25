import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] ranges = line.split(",");

        long res = 0;

        for (String range : ranges) {
            String[] pair = range.split("-");
            long start = Long.parseLong(pair[0]);
            long end = Long.parseLong(pair[1]);

            for (long i = start; i <= end; i++) {
                String s = Long.toString(i);
                if (s.length() % 2 != 0) continue;

                int splitIndex = s.length() / 2;
                String first = s.substring(0, splitIndex);
                String second = s.substring(splitIndex);
                if (first.equals(second)) {
                    res += i;
                }
            }
        }

        System.out.println(res);
        scanner.close();
    }
}
