import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class NavegadorDeImagens extends JFrame {

    private JPanel galeriaPanel;
    private JLabel imagemExibida;
    private JScrollPane scrollPane;

    public NavegadorDeImagens() {
        super("Navegador de Imagens");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // botao pra escolhe sua pasta que voce quer a pasta

        JButton selecionarPastaBtn = new JButton("Selecionar Pasta");
        selecionarPastaBtn.addActionListener(e -> selecionarPasta());

        imagemExibida = new JLabel("", SwingConstants.CENTER);
        imagemExibida.setPreferredSize(new Dimension(600, 600));

        galeriaPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 4 coluna de imagem pra escolhe
        scrollPane = new JScrollPane(galeriaPanel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, imagemExibida);
        splitPane.setDividerLocation(300);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(selecionarPastaBtn, BorderLayout.NORTH);
        getContentPane().add(splitPane, BorderLayout.CENTER);
    }

    private void selecionarPasta() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File pastaSelecionada = fileChooser.getSelectedFile();
            carregarImagensDaPasta(pastaSelecionada);
        }
    }

    private void carregarImagensDaPasta(File pasta) {
        galeriaPanel.removeAll(); // limpa se voce nao quiser mais ve a imagem

        File[] arquivos = pasta.listFiles((dir, nome) -> {
            String nomeLower = nome.toLowerCase();
            return nomeLower.endsWith(".jpg") || nomeLower.endsWith(".png") || nomeLower.endsWith(".gif");
        });

        if (arquivos != null) {
            for (File imgFile : arquivos) {
                try {
                    BufferedImage imagem = ImageIO.read(imgFile);
                    if (imagem != null) {
                        Image thumbnail = imagem.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        JLabel thumbLabel = new JLabel(new ImageIcon(thumbnail));
                        thumbLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        thumbLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        thumbLabel.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                imagemExibida.setIcon(new ImageIcon(imagem.getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
                            }
                        });
                        galeriaPanel.add(thumbLabel);
                    }
                } catch (Exception ex) {
                    System.err.println("Erro ao carregar imagem: " + imgFile.getName());
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
