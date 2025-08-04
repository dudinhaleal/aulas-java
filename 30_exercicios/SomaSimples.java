import java.util.Scanner;

public class SomaSimples {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o primeiro número: ");
        double num1 = input.nextDouble();
        System.out.println("Informe o segundo número: ");
        double num2 = input.nextDouble();
        input.close();

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
}