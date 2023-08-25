package encryptdecrypt;

public class UnicodeCoder implements Coder {
    StringBuilder builder = new StringBuilder();

    public String encode(String string, int key) {
        char[] letters = string.toCharArray();
        for (char letter: letters) {
            char encodedLetter = (char) ((letter + key));
            builder.append(encodedLetter);
        }

        return builder.toString();
    }

    public String decode(String string, int key) {
        char[] letters = string.toCharArray();
        for (char letter: letters) {
            char decodedLetter = (char) ((letter - key));
            builder.append(decodedLetter);
        }

        return builder.toString();
    }
}
