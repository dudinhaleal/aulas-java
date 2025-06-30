import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class NavegadorDeImagens extends JFrame {

    private JPanel galeriaPanel;
    private JLabel imagemExibida;

    public NavegadorDeImagens() {
        super("Navegador de Imagens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JButton selecionarPastaBtn = new JButton("Selecionar Pasta");
        selecionarPastaBtn.addActionListener(e -> selecionarPasta());

        imagemExibida = new JLabel("", SwingConstants.CENTER);

        galeriaPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        JScrollPane scrollPane = new JScrollPane(galeriaPanel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, imagemExibida);
        splitPane.setDividerLocation(300);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(selecionarPastaBtn, BorderLayout.NORTH);
        getContentPane().add(splitPane, BorderLayout.CENTER);
    }

    private void selecionarPasta() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            carregarImagens(fileChooser.getSelectedFile());
        }
    }

    private void carregarImagens(File pasta) {
        galeriaPanel.removeAll();

        File[] arquivos = pasta.listFiles(f -> f.getName().toLowerCase().matches(".*\\.(jpg|png|gif)$"));

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                try {
                    BufferedImage img = ImageIO.read(arquivo);
                    Image thumbnail = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    JLabel thumbLabel = new JLabel(new ImageIcon(thumbnail));
                    thumbLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    thumbLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    thumbLabel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            imagemExibida.setIcon(new ImageIcon(img.getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
                        }
                    });
                    galeriaPanel.add(thumbLabel);
                } catch (Exception ex) {
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
