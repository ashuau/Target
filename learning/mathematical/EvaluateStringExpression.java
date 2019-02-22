package learning.mathematical;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateStringExpression
{
    public static double evaluate(String expression) throws InvalidExpression {
        char[] tokens = expression.toCharArray();
        boolean invalidOperator = false;

        // Stack for numbers: 'values'
        Stack<Double> values = new Stack<>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                int k = i;
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sbuf.append(tokens[i++]);

                }
                values.push(Double.parseDouble(sbuf.toString()));
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^')
            {
                if (values.isEmpty()) {
                    throw new InvalidExpression("Invalid Expression");
                }
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;

        if ((op1 == '*' || op1 == '/' || op1 == '^') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '^':
                return Math.pow(a,b);
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            default:
                throw new UnsupportedOperationException("Unknown operator");
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of testcases :");
        int testCaseNo = in.nextInt();
        List result = new ArrayList();
        in = new Scanner(System.in);
        for (int i = 0; i < testCaseNo; i++) {
            System.out.println("enter expression :");
            try {
                result.add(EvaluateStringExpression.evaluate(in.nextLine()));
            } catch (InvalidExpression invalidExpression) {
                result.add(invalidExpression.getMessage());
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println("case #"+(i+1)+": "+result.get(i));
        }
      /*  System.out.println(EvaluateStringExpression.evaluate("10 + 2 ^ 3"));
        System.out.println(EvaluateStringExpression.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateStringExpression.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateStringExpression.evaluate("100 * ( 2 + 12 ) / 14"));*/
    }
}

class InvalidExpression extends Exception {
    InvalidExpression(String msg) {
        super(msg);
    }
}
