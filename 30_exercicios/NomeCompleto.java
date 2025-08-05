import java.util.Scanner;
 
public class NomeCompleto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
 
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
 
        System.out.println("Nome completo: " + nome + " " + sobrenome);
 
        scanner.close();
    }
}
 