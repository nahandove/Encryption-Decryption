package encryptdecrypt;

public class CoderFactory {
    public Coder getCoder(String type) {
        if ("unicode".equals(type)) {
            return new UnicodeCoder();
        }
        return new ShiftCoder();
    }
}
