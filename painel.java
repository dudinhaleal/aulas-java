import java.awt.*;
import java.io.File;
import javax.swing.*;
 
public class painel {
 
    public static void main(String[] args) {
        JFrame frame = new JFrame("Explorador de Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
 
        JButton chooseButton = new JButton("Escolher Imagem");
        JLabel thumbnailLabel = new JLabel();
 
        chooseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    ImageIcon originalImage = new ImageIcon(selectedFile.getAbsolutePath());
                    Image resizedImage = originalImage.getImage().getScaledInstance(
                            500, 500, Image.SCALE_SMOOTH
                    );
                    ImageIcon thumbnail = new ImageIcon(resizedImage);
                    thumbnailLabel.setIcon(thumbnail);
                    thumbnailLabel.setVisible(true); // se ficar invisível
                    frame.revalidate();
                    frame.repaint(); // renova quando clica
                } catch (Exception ex) {
                    ex.printStackTrace(); // quebra se tiver algum erro
                }
            }
        });

        
// Deixa o botão e o label mais bonitos
chooseButton.setFont(new Font("Arial", Font.BOLD, 26));
thumbnailLabel.setVisible(true);
chooseButton.setBackground(new Color(70, 130, 180));
chooseButton.setForeground(Color.WHITE);
chooseButton.setFocusPainted(false);

thumbnailLabel.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
thumbnailLabel.setPreferredSize(new Dimension(500, 500));
chooseButton.setPreferredSize(new Dimension(400, 100));
thumbnailLabel.setHorizontalAlignment(JLabel.CENTER);
thumbnailLabel.setVerticalAlignment(JLabel.CENTER);

frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setLayout(new BorderLayout());
        frame.add(chooseButton, BorderLayout.NORTH);
        frame.add(thumbnailLabel, BorderLayout.CENTER);
        frame.add(thumbnailLabel);
        thumbnailLabel.setVisible(false);
 
        frame.pack();
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }
}