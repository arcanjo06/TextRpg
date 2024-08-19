package main;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    
    private JTextArea textArea;
    private JButton continueButton;
    private Player player;

    public GameWindow(Player player) {
        this.player = player;

        // Configurações da janela
        setTitle("Dead City");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Área de texto
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botão para continuar
        continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.continueJourney();
            }
        });

        JPanel panel = new JPanel();
        panel.add(continueButton);
        add(panel, BorderLayout.SOUTH);
    }

    public void displayText(String text) {
        textArea.append(text + "\n");
    }

    public static void main(String[] args) {
        // Inicializa o jogo
        Player player = new Player("Jogador");
        GameWindow window = new GameWindow(player);
        window.setVisible(true);
    }
}
