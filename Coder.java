package encryptdecrypt;

public interface Coder {
    String encode(String string, int key);
    String decode(String string, int key);
}
