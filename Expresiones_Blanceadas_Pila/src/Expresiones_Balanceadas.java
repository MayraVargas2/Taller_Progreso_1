import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Expresiones_Balanceadas {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Verificar Expresiones Balanceadas");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los elementos de la interfaz
        JLabel label = new JLabel("Introduce la expresión matemática:");
        JTextField inputField = new JTextField(20);
        JButton verificarButton = new JButton("Verificar");
        JTextArea outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);

        // Crear un panel para colocar los elementos
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(verificarButton);
        panel.add(new JScrollPane(outputArea));

        // Añadir el panel a la ventana principal
        frame.add(panel);
        frame.setVisible(true);

        // Acción del botón Verificar
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = inputField.getText();
                if (estaBalanceada(expresion)) {
                    outputArea.setText("La expresión está Balanceada.");
                } else {
                    outputArea.setText("La expresión NO está Balanceada.");
                }
            }
        });
    }

    // Función para verificar si una expresión está balanceada
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
}


/*import java.util.Scanner;
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
*/