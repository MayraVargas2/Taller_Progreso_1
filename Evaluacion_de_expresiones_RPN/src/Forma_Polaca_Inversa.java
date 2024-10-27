import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Forma_Polaca_Inversa {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Evaluar Expresión en RPN");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los elementos de la interfaz
        JLabel label = new JLabel("Introduce la expresión en RPN:");
        JTextField inputField = new JTextField(20);
        JButton evaluarButton = new JButton("Evaluar");
        JTextArea outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);

        // Crear un panel para colocar los elementos
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(evaluarButton);
        panel.add(new JScrollPane(outputArea));

        // Añadir el panel a la ventana principal
        frame.add(panel);
        frame.setVisible(true);

        // Acción del botón Evaluar
        evaluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = inputField.getText();
                String[] tokens = expresion.split(" ");
                int resultado = evaluarRPN(tokens);
                outputArea.setText("Resultado: " + resultado);
            }
        });
    }

    // Función para evaluar la expresión en RPN
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
}


/*import java.util.Scanner;
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
}*/