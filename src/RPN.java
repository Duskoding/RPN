
import java.util.Stack;

/**
 * A calculator that evaluates expressions written in Reverse Polish Notation (postfix),
 * where the operator comes after its two numbers, for example "3 4 +" is 7.
 * Supports +, -, *, / and %.
 */
public class RPN{
    /**
     * Evaluates an RPN expression. Numbers get pushed onto a stack, and when an operator
     * shows up the top two numbers are popped, calculated, and the result is pushed back.
     *
     * @param problem the expression, with each number and operator separated by a space
     * @return the result as a String, or an error message if the expression is invalid
     */
    public String evaluate(String problem){
        Stack<Double> numbers = new Stack<>();
        if(problem.trim().isEmpty()){
            return "empty string";
        }
        String[] expression = problem.trim().split("\\s+");//split on any amount of spaces so extra spaces dont break it

        for(String token : expression){
            try {
                numbers.push(Double.parseDouble(token));
                continue;
            } catch (NumberFormatException e) {
                //ignore, continue processing if the token is not a number
            }
            if(numbers.size() < 2) {   //for when there's an operator but not enough numbers to operate
                return "not enough numbers, operator ignored";
            }

            double value2 = numbers.pop();
            double value1 = numbers.pop();//pop here so you don't need to pop every time
            double result;//declare things or else the switch doesn't work

            switch(token){
                case "+":
                    result = value1 + value2;
                    numbers.push(result);
                    break;
                case "-":
                    result = value1 - value2;
                    numbers.push(result);
                    break;
                case "*":
                    result = value1 * value2;
                    numbers.push(result);
                    break;
                case "/":
                    if(value2 == 0){
                        return "error division by zero";
                    }
                    result = value1 / value2;
                    numbers.push(result);
                    break;
                case "%":
                    result = value1 % value2;
                    numbers.push(result);
                    break;
                default:
                    return "not an operator or a number, something went wrong";
            }
        }
        if (numbers.size() == 1){
            return String.valueOf(numbers.pop());         //i wanted to use a toString but it was complicated and research said this was better
        } else if (numbers.size() > 1){
            return String.valueOf(numbers.pop()) + "\nextra junk ignored";
        } else{
            return "empty string";
        }
    }
}