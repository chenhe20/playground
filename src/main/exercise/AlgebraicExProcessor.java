import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.*;
import java.util.stream.Stream;


/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Evaluates Infix Algebraic Expressions
 *
 */
public class AlgebraicExProcessor {

    /**
     * Returns true if the parentheses, brackets, and the braces in an expression are paired correctly
     * @return
     */
    public static boolean checkBalance(String exp) throws Exception {
        Stack<Character> delimiterStack = new Stack();
        boolean isBalanced = true;

        char[] chars = exp.toCharArray();
        int charIdx = 0;

        while (isBalanced && charIdx < chars.length) {
            char nextChar = chars[charIdx];
            charIdx ++;

            if (nextChar == '(') {
                delimiterStack.push(nextChar);
            } else if (nextChar == ')') {
                Character openDelimiter = delimiterStack.pop();
                if (openDelimiter == null) return false;
                isBalanced = openDelimiter == '(';
            } else {
                // Checks if is a digit number
                if (!Character.isDigit(nextChar)) {
                   throw new Exception("Invalid expression(Illegal character): " + exp);
                }
                // Checks next char
            }
        }
        if (!delimiterStack.isEmpty()) isBalanced = false;
        return isBalanced;
    }

    /** A utility function to return precedence of a given operator
     * Higher returned value means higher precedence
     */
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * The main method that converts given infix expression to postfix expression.
     * @param exp
     * @return
     */
    static String infixToPostfix(String exp) throws RuntimeException
    {

        // Pre-process
        exp = exp.replace(" ", "");

        if (exp.charAt(0) == '-') {
            StringBuilder sb = new StringBuilder(exp);
            sb.insert(0, "0");
            exp = sb.toString();
        }

        // inits empty String for result
        String result = new String("");

        // inits empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isDigit(c)) {
                StringBuffer intValue = new StringBuffer(String.valueOf(c));
                while(i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1)) ) {
                    intValue.append(exp.charAt(i + 1));
                    i ++;
                }
                intValue.append(" ");
                result += intValue.toString();
            }
                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(') stack.push(c);
                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();

            } else {
                // an operator is encountered
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                throw new RuntimeException("Invalid Expression: " + exp);
            result += stack.pop();
        }
        return result;
    }

    /**
     *  Evaluates value of a given postfix expression
     *  */
    protected  static int evalPostfix(String exp)
    {
        Stack<Integer> st = new Stack();
        // Loop to scan all elements of the expression one by one
        for(int i=0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);

            // Gets the integer and pushes its value into the stack
            if(Character.isDigit(ch)) {
                StringBuffer intValue = new StringBuffer(String.valueOf(ch));
                i++;
                while(i < exp.length() && Character.isDigit(exp.charAt(i)) ) {
                    intValue.append(exp.charAt(i));
                    i ++;
                }
                st.push(Integer.valueOf(intValue.toString()));

            } else if (ch == ' '){
                // If next number comes
                continue;
            } else {
                // If the operator comes it will be evaluated
                int value1 = st.pop();
                int value2 = st.pop();

                switch(ch)
                {
                    case '+':
                        st.push(value2 + value1);
                        break;

                    case '-':
                        st.push(value2 - value1);
                        break;

                    case '*':
                        st.push(value2*value1);
                        break;
                    case '/':
                        st.push(value2/value1);
                        break;
                }
            }
        }
        return st.pop();
    }

    public static int eval(String exp) throws Exception{
        if (checkBalance(exp)) return evalPostfix(infixToPostfix(exp));
        else throw new Exception("Invalid Input (Not Balanced): " + exp);
    }

    public static void main(String[] args) {
        String a = "1+(1*31)";
        String b = "1+(1*3)";
        String c = "(5+5*3+(3+3))";
        String d = "123";
        String e = "111";
        String f = "0-1*1+15- 30";
        String g = "1+(5 * 3)*10";

//        try {
//            System.out.println(eval(f));
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }

        System.out.println(calDiscounted(0.005));
        //System.out.println(calDiscounted(0.02));

    }

    public static double calDiscounted(double interestRate) {
        double coupon = 1;
        double principle = 100;
        double term = 5;


        double front = 0;
        for (int i = 1; i <= term; i++) {
            front = (coupon / Math.pow((1 + interestRate), i)) + front;
        }

        double behind = Math.pow((1 + interestRate), term);
        behind = 100 / behind;

        System.out.println("behind is: " + behind);

        return front + behind;

    }



}
