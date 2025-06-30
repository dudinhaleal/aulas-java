import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
//  biblioteca java 

public class NavegadorDeImagens extends JFrame {

    // criando as variáveis 
    private JPanel galeriaPanel;
    //  j panel é o painel onde fica as miniaturas das imagens
    private JLabel imagemExibida;
    // j label é quando voce clica na miniatura e ela amplia
    public NavegadorDeImagens() {

        // título que fica laa em cima
        super("Navegador de Imagens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // botão que abre uma janelinha pra escolher uma pasta do seu pc que tem inmagem dentro
        JButton selecionarPastaBtn = new JButton("Selecionar Pasta");   
        selecionarPastaBtn.addActionListener(e -> selecionarPasta());

        imagemExibida = new JLabel("", SwingConstants.CENTER);

        // jscroll é pra scrollar as img (subir e descer e ir pro lado)
        galeriaPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        JScrollPane scrollPane = new JScrollPane(galeriaPanel);

        // organiza a galeria na esquerda e quando clica na imagem mostra ela grandona na direita
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, imagemExibida);
        splitPane.setDividerLocation(300);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(selecionarPastaBtn, BorderLayout.NORTH);
        getContentPane().add(splitPane, BorderLayout.CENTER);
    }

    private void selecionarPasta() {
        // quando clica em selecionar pasta o programa abre seletor de arquivos (J file chooser) que deixa você escolher uma pasta
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            carregarImagens(fileChooser.getSelectedFile());
        }
    }

    private void carregarImagens(File pasta) {
        

        File[] arquivos = pasta.listFiles(f -> f.getName().toLowerCase().matches(".*\\.(jpg|png|gif)$"));
        // lista os arquivos da pasta
        if (arquivos != null) {
            // verifica e processa os arquivos
            for (File arquivo : arquivos) {
                try {

                    // ImageIO.read (lê a imagem do arquivo)
                    BufferedImage img = ImageIO.read(arquivo);

                    // redimensiona a imagem pra 100x100 pixels (miniatura)
                    Image thumbnail = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 

                    // cria um j label com o nome de thumbnail com a miniatura como ícone
                    JLabel thumbLabel = new JLabel(new ImageIcon(thumbnail));

                    // estilo do painel todo fofinho cuti cuti
                    // adicina borda cinza pra destacar a miniatura
                    // quando o mouse passa sobre a miniatura ele vira uma mãozinha
                    thumbLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    thumbLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                    // quando clica na miniatura ela fica grandona e vai exibir ao lado
                    thumbLabel.addMouseListener(new MouseAdapter() {

                        public void mouseClicked(MouseEvent e) {
                            imagemExibida.setIcon(new ImageIcon(img.getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
                        }
                    });
                    galeriaPanel.add(thumbLabel);

                } catch (Exception ex) {
                    // se houver algum erro vai aparecer esta mensagem
                    System.err.println("Erro ao carregar imagem: " + arquivo.getName());
                }
            }
        }

        galeriaPanel.revalidate();
        galeriaPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NavegadorDeImagens().setVisible(true));
    }
}
