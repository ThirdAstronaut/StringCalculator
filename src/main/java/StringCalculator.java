import java.util.Arrays;
import java.util.stream.IntStream;

class StringCalculator {

    static int add(String numbers) throws IllegalArgumentException {
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
        int[] negatives = Arrays.stream(tokens).mapToInt(Integer::parseInt).filter(x -> x < 0).toArray();
        if(negatives.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : negatives) {
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.toString().length()-1);
            throw new IllegalArgumentException("negatives not allowed " + stringBuilder.toString());

        }return Arrays.stream(tokens).mapToInt(Integer::parseInt).filter(x -> x < 1_000).sum();
    }
}
