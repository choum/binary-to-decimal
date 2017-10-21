import java.util.*;
public class BinaryToBits {
    public static void main(String[] args) {
        boolean x = true;
        while (x) {
            System.out.print("Enter a binary number: ");
            String input = getInput();
            if (checkFormat(input)) {
                convert(input);
                x = false;
            } else {
                System.out.println("Invalid input.");
            }
        }     
    }
    public static String getInput() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        return input;
    }
    public static boolean checkFormat(String input) {
        boolean x = false; 
        if (input.matches("[01]+")) {
            ArrayList<String> parts = new ArrayList<>(Arrays.asList(input.split("(?<!^)")));
            x = true;
        }     
        return x;
    }
    public static void convert(String x) {
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(x.split("(?<!^)")));
        ArrayList<Integer> bits = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bits.add((int)Math.pow(2,i));
        }
        int partSize = parts.size() - 1;
        int finalBit = 0;
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).equals("1")) {
                finalBit += (int)Math.pow(2,partSize);
            } 
            partSize--;
        }
        System.out.println("The bit count is " + finalBit);
    }
}
