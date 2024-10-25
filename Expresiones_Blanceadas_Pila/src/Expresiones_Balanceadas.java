import java.util.Scanner;
import java.util.Stack;

public class Expresiones_Balanceadas {
    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();
        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) return false;
                char apertura = pila.pop();
                if ((c == ')' && apertura != '(') || (c == '}' && apertura != '{') || (c == ']' && apertura != '[')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la expresión matemática con paréntesis:");
        String expresion = scanner.nextLine();

        if (estaBalanceada(expresion)) {
            System.out.println("Balanceada");
        } else {
            System.out.println("No balanceada");
        }
    }
}
