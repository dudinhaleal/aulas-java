import java.util.Scanner;
 
public class ValidarSenha {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        String senha = "";
 
        while (!senha.equals("1234")) {
            System.out.print("Digite a senha: ");
            senha = scanner.nextLine();
 
            if (!senha.equals("1234")) {
                System.out.println("Senha incorreta!");
            }
        }
 
        System.out.println("Acesso liberado!");
        scanner.close();
    }
}