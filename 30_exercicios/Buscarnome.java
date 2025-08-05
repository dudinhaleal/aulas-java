import java.util.Scanner;
 
public class Buscarnome {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[10];
        boolean encontrado = false;
 
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }
 
        System.out.print("Digite um nome para buscar: ");
        String busca = scanner.nextLine();
 
        for (String nome : nomes) {
            if (nome.equalsIgnoreCase(busca)) {
                encontrado = true;
                break;
            }
        }
 
        if (encontrado) {
            System.out.println("Nome encontrado!");
        } else {
            System.out.println("Nome não encontrado.");
        }
 
        scanner.close();
    }
}