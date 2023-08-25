package encryptdecrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String method = "enc";
        String message = "";
        int key = 0;
        String outputFile = "";
        boolean outputToFile = false;
        boolean hasData = false;

        CoderFactory factory = new CoderFactory();
        Coder coder = factory.getCoder("shift");

        try {
            for (int i = 0; i < args.length - 1; i += 2) {
                switch (args[i]) {
                    case "-alg":
                        coder = factory.getCoder(args[i + 1]);
                        break;
                    case "-mode":
                        method = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-in":
                        if (!hasData) {
                            message = readFile(args[i + 1]);
                        }
                        break;
                    case "-out":
                        outputFile = args[i + 1];
                        outputToFile = true;
                        break;
                    case "-data":
                        message = args[i + 1];
                        hasData = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Error! Invalid input!");
                }
            }

            if ("enc".equals(method)) {
                message = coder.encode(message, key);
            } else if ("dec".equals(method)) {
                message = coder.decode(message, key);
            }

            if (outputToFile) {
                writeFile(outputFile, message);
            } else {
                System.out.println(message);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readFile(String fileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String content = "";
            while (fileReader.ready()) {
                content += fileReader.readLine();
            }
            return content;
        } catch (IOException e) {
            System.out.println("Error! Something went wrong reading the file.");
        }
        return null;
    }

    public static void writeFile(String fileName, String message) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (char letter: message.toCharArray()) {
                fileWriter.write(letter);
            }
        } catch (IOException e) {
            System.out.println("Error! Something went wrong writing to file.");
        }
    }
}
