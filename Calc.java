import java.util.Scanner;

class Calc {
    public static void main(String[] args) throws Exception {

        System.out.print("Input: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Main action = new Main();
        System.out.println(action.calc(input));

    }
}