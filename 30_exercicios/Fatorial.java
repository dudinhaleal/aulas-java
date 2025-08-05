import java.util.Scanner;
 
public class Fatorial {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
 
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
 
        int fatorial = 1;
 
        for (int i = numero; i >= 1; i--) {
            fatorial *= i;
        }
 
        System.out.println("Fatorial de " + numero + " é " + fatorial);
 
        scanner.close();
    }
}