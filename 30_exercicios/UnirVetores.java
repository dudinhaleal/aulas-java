import java.util.Scanner;
 
public class UnirVetores {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
 
        int[] vetor1 = new int[5];
        int[] vetor2 = new int[5];
        int[] vetorUnido = new int[10];
 
        System.out.println("Preencha o primeiro vetor:");
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor1[i] = scanner.nextInt();
        }
 
        System.out.println("Preencha o segundo vetor:");
        for (int i = 0; i < vetor2.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor2[i] = scanner.nextInt();
        }
 
        // Copiar os vetores para o terceiro vetor
        for (int i = 0; i < 5; i++) {
            vetorUnido[i] = vetor1[i];
            vetorUnido[i + 5] = vetor2[i];
        }
 
        System.out.println("Vetor unido:");
        for (int i = 0; i < vetorUnido.length; i++) {
            System.out.print(vetorUnido[i] + " ");
        }
 
        scanner.close();
    }
}