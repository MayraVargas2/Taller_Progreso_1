import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;


public class Gestion_de_una_fila {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<String> fila = new LinkedList<String>();
		
		System.out.println("Ingrese el numero de clientes");
		int num = scan.nextInt();
		scan.nextLine();
		 
		System.out.println("\nIngrese los nombres de los clientes");
		for (int i = 0; i < num; i++) {
			fila.add(scan.nextLine());
		}
		
		System.out.println();
		while(!fila.isEmpty()) {
			System.out.println(fila.poll() + " ha sido atendido/a");
		}	
	}
}
