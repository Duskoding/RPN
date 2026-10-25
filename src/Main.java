import java.util.Scanner;

public class Main{
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);

        RPN calc = new RPN();

        System.out.println("This is a Reverse Polish Notation calculator. Please separate each number and operator with a space.");
        System.out.println("Enter an RPN expression or type exit to exit");

        for(String problem = kb.nextLine();
            !"exit".equals(problem);
            problem = kb.nextLine()){
            String result = calc.evaluate(problem);
            System.out.println(result);
            System.out.println();
            System.out.println("Enter an RPN expression or type exit to exit");
        }

    }
}
