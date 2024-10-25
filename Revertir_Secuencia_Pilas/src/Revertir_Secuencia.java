import java.util.Stack;
import java.util.Scanner;



public class Revertir_Secuencia {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> serie = new Stack<>();
		
		System.out.println("Ingrese una serie de numeros enteros separados por espacios");
		String[] numeros = scan.nextLine().split(" ");
		
		for (String numero : numeros){
			serie.push(Integer.parseInt(numero));
		}
		
		System.out.println("Secuencia invertida");
		while (!serie.isEmpty()) {
			System.out.print(serie.pop() + " ");
		}			
	}
}



/*import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Revertir_Secuencia {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Revertir Secuencia con serie");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los elementos de la interfaz
        JLabel label = new JLabel("Introduce una secuencia de números separados por espacios:");
        JTextField inputField = new JTextField(20);
        JButton revertirButton = new JButton("Revertir");
        JTextArea outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);

        // Crear un panel para colocar los elementos
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(revertirButton);
        panel.add(new JScrollPane(outputArea));

        // Añadir el panel a la ventana principal
        frame.add(panel);
        frame.setVisible(true);

        // Acción del botón Revertir
        revertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String[] numeros = input.split(" ");
                Stack<Integer> serie = new Stack<>();

                for (String numero : numeros) {
                    serie.push(Integer.parseInt(numero));
                }
                
                StringBuilder resultado = new StringBuilder();
                while (!serie.isEmpty()) {
                    resultado.append(serie.pop()).append(" ");
                }

                // Mostrar el resultado en el área de salida
                outputArea.setText("Secuencia invertida: " + resultado.toString());
            }
        });
    }
}
*/