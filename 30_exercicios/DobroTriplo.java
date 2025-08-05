import java.util.Scanner;
 
public class DobroTriplo {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
 
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
 
        System.out.println("Dobro: " + (numero * 2));
        System.out.println("Triplo: " + (numero * 3));
 
        scanner.close();
    }
}