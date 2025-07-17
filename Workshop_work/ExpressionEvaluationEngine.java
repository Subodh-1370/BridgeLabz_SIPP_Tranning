import java.util.*;

// Interface
interface ExpressionEvaluator {
    int evaluate(String expression);
}

// PostfixEvaluator implements ExpressionEvaluator
class PostfixEvaluator implements ExpressionEvaluator {

    @Override
    public int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (String token : expression.split(" ")) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOp(token, a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private int applyOp(String op, int a, int b) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}

// Infix to Postfix converter
class InfixToPostfix {

    public static String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch).append(" ");
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // remove '('
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private static boolean isOperator(char ch) {
        return "+-*/".indexOf(ch) != -1;
    }

    private static int precedence(char ch) {
        return (ch == '+' || ch == '-') ? 1 : 2;
    }
}

// Main class
public class ExpressionEvaluationEngine {
    public static void main(String[] args) {
        String infix = "3+(2*4)-5"; // You can change this
        String postfix = InfixToPostfix.convert(infix);

        System.out.println("Infix Expression: " + infix);
        System.out.println("Converted Postfix: " + postfix);

        ExpressionEvaluator evaluator = new PostfixEvaluator();
        int result = evaluator.evaluate(postfix);

        System.out.println("Evaluation Result: " + result);
    }
}
