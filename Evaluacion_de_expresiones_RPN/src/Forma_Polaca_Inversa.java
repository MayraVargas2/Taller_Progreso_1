import java.util.Scanner;
import java.util.Stack;

public class Forma_Polaca_Inversa {
    public static int evaluarRPN(String[] tokens) {
        Stack<Integer> pila = new Stack<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                pila.push(Integer.parseInt(token));
            } else {
                int b = pila.pop();
                int a = pila.pop();
                switch (token) {
                    case "+":
                        pila.push(a + b);
                        break;
                    case "-":
                        pila.push(a - b);
                        break;
                    case "*":
                        pila.push(a * b);
                        break;
                    case "/":
                        pila.push(a / b);
                        break;
                }
            }
        }
        return pila.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la expresión en Forma Polaca Inversa:");
        String[] tokens = scanner.nextLine().split(" ");

        int resultado = evaluarRPN(tokens);
        System.out.println("Resultado: " + resultado);
    }
}
