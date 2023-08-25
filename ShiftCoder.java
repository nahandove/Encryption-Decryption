package encryptdecrypt;

public class ShiftCoder implements Coder {
    int capitalAlphaStart = 65;
    int capitalAlphaEnd = 90;
    int smallAlphaStart = 97;
    int smallAlphaEnd = 122;
    StringBuilder builder = new StringBuilder();

    public String encode(String string, int key) {
        int keyRemainder = key % 26;
        char[] letters = string.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char letter: letters) {
            if (Character.isAlphabetic(letter)) {
                char encodedLetter = (char) ((letter + keyRemainder));
                if (letter >= capitalAlphaStart && letter <= capitalAlphaEnd) {
                    if (encodedLetter > capitalAlphaEnd) {
                        encodedLetter -= 26;
                    }
                } else if (letter >= smallAlphaStart && letter <= smallAlphaEnd) {
                    if (encodedLetter > smallAlphaEnd) {
                        encodedLetter -= 26;
                    }
                }
                builder.append(encodedLetter);
            } else {
                builder.append(letter);
            }
        }
        return builder.toString();
    }

    public String decode(String string, int key) {
        int keyRemainder = key % 26;
        char[] letters = string.toCharArray();

        for (char letter: letters) {
            if (Character.isAlphabetic(letter)) {
                char decodedLetter = (char) ((letter - keyRemainder));
                if (letter >= capitalAlphaStart && letter <= capitalAlphaEnd) {
                if (decodedLetter < capitalAlphaStart) {
                    decodedLetter += 26;
                }

                } else if (letter >= smallAlphaStart && letter <= smallAlphaEnd) {
                    if (decodedLetter < smallAlphaStart) {
                        decodedLetter += 26;
                    }
                }
                builder.append(decodedLetter);
            } else {
                builder.append(letter);
            }
        }

        return builder.toString();
    }
}
