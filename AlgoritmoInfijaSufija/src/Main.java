//Hecho por: Andrés López Corrales
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Metodos metodos = new Metodos(); //Instancia clase métodos

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe una operación Infija: ");
        String operacioninfija = scanner.nextLine(); //OperaciónInfija - Ejemplo: (A+B)*(C/D)

        String operacionSufija = metodos.toPosfijo(operacioninfija); //Operación sufija

        System.out.println("Operación sufija: " + operacionSufija); //Impresión operación sufija

    }//end main
}