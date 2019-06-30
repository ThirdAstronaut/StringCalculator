import java.util.Arrays;

class StringCalculator {

    static int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            return customDelimiter(numbers.substring(4), String.valueOf(numbers.charAt(2)));
        } else {

            return customDelimiter(numbers);
        }
    }

    private static int customDelimiter(String numbers) {
        return customDelimiter(numbers, "[,\n]");
    }

    private static int customDelimiter(String numbers, String regex) {
        String[] tokens = numbers.split(regex);
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
