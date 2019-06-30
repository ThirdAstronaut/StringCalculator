import java.util.Arrays;

class StringCalculator {

    static int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }

        String[] tokens = numbers.split("[,\n]");
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
