class StringCalculator {

    static int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }

        String[] tokens = numbers.split(",");
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        } else {
            return Integer.valueOf(tokens[0]) + Integer.valueOf(tokens[1]);
        }
    }

}
