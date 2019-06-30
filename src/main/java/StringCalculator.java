import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringCalculator {

    static int add(String numbers) throws IllegalArgumentException {
        if (numbers.equals("")) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            int indexOfNewLine = numbers.indexOf("\n");

            String[] tokens = numbers.split("");
            StringBuilder delimitres = new StringBuilder();
            int regexLength = 1;
            for (int i = 0; i < tokens.length; i++) {
                if(tokens[i].equals("[") && i < tokens.length-1){
                    regexLength = 1;
                    while(i < tokens.length-1 && !tokens[i+1].equals("]")) {
                        delimitres.append(tokens[i+1]);
                        i++;
                        regexLength++;
                    }
                    regexLength--;
                }
            }
            if(delimitres.toString().length()==0){
                return customDelimiter(numbers.substring(indexOfNewLine + 1), numbers.substring(2, indexOfNewLine),indexOfNewLine-2);
            }else
            return customDelimiter(numbers.substring(indexOfNewLine + 1), delimitres.toString(), regexLength);

        } else {

            return defaultDelimiter(numbers);
        }
    }

    private static int defaultDelimiter(String numbers) {
        return customDelimiter(numbers, "[,\n]", 1);
    }

    private static int customDelimiter(String numbers, String regex, int regexLength) {
        String[] tokens = numbers.split("["+regex+"]{"+regexLength+"}");
        int[] negatives = Arrays.stream(tokens).mapToInt(Integer::parseInt).filter(x -> x < 0).toArray();
        if (negatives.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : negatives) {
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
            throw new IllegalArgumentException("negatives not allowed " + stringBuilder.toString());

        }
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).filter(x -> x < 1_000).sum();
    }
}
