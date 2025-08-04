import java.util.Scanner;

public class MaiorMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("digite o primeiro número: ");
        int num1 = scanner.nextInt();
        System.out.print("digite o segundo número: ");
        int num2 = scanner.nextInt();
        System.out.print("digite o terceiro número: ");
        int num3 = scanner.nextInt();
        int maior = Math.max(num1, Math.max(num2, num3));
        int menor = Math.min(num1, Math.min(num2, num3));
        System.out.println("o maior número é: " + maior);
        System.out.println("o menor número é: " + menor);
    }
}
