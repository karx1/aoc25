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

                boolean invalid = false;
                for (int j = 1; j <= s.length(); j++) {
                    if (s.length() % j != 0) continue;

                    int splitIndex = s.length() / j;
                    int pos = 0;
                    String first = s.substring(pos, pos + splitIndex);
                    boolean holds = true;
                    if (first.equals(s)) holds = false;
                    for (int k = 0; k < j - 1; k++) {
                        pos += splitIndex;
                        String sub = s.substring(pos, pos + splitIndex);
                        if (!first.equals(sub)) {
                            holds = false;
                        }
                    }

                    if (holds) {
                        invalid = true;
                        break;
                    }
                }

                if (invalid) res += i;
            }
        }

        System.out.println(res);
        scanner.close();
    }
}
