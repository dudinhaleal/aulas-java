import java.util.Scanner;
public class ParImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("digite um número: ");
        int numero = scanner.nextInt();
        if (numero % 2 == 0) {
            System.out.println("o número é par.");
        } else {
            System.out.println("o número é ímpar.");
        }
    }
}