@Service
public class ISBNGenerator {

    public String generateISBN() {
        Random rand = new Random();
        int[] digits = new int[12];
        digits[0] = 9;
        digits[1] = 7;
        digits[2] = 8;

        for (int i = 3; i < 12; i++) {
            digits[i] = rand.nextInt(10);
        }

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * ((i % 2 == 0) ? 1 : 3);
        }

        int checkDigit = (10 - (sum % 10)) % 10;

        StringBuilder isbn = new StringBuilder();
        for (int digit : digits) isbn.append(digit);
        isbn.append(checkDigit);

        return isbn.toString();
    }
}
