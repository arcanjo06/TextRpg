import javax.swing.*;

// Classe principal do jogo
public class GameGUI {

    private static Player player;
    private static GameWindow gameWindow;
    private static boolean isRunning;
    static String playerName;

    public static void main(String[] args) {
        // Iniciar o jogo
        startGame();
    }

    public static void startGame() {
        // Cria a janela de jogo
        gameWindow = new GameWindow();
        gameWindow.setVisible(true);

        // Exibe o título do jogo
        gameWindow.displayText("DEAD CITY");
        gameWindow.displayText("By Levi Arcanjo");

        // Chama a função para obter o nome do jogador
        askForPlayerName();

        // Inicia o loop do jogo
        isRunning = true;
        Story.printIntro(gameWindow);
        Story.printFirstActIntro(gameWindow);

        gameLoop();
    }

    private static void askForPlayerName() {
        boolean nameSet = false;

        while (!nameSet) {
            // Captura o nome do jogador
            playerName = JOptionPane.showInputDialog(null, "Olá Viajante, Como é seu nome?", "Nome do Jogador", JOptionPane.QUESTION_MESSAGE);

            if (playerName == null || playerName.trim().isEmpty()) {
                // Se o jogador cancelar ou não inserir um nome válido
                JOptionPane.showMessageDialog(null, "Por favor, insira um nome válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                // Confirma o nome com o jogador
                int input = JOptionPane.showConfirmDialog(null, "Seu nome é: " + playerName + "\nEstá certo?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (input == JOptionPane.YES_OPTION) {
                    nameSet = true;
                }
            }
        }

        // Instancia o jogador após o nome ser confirmado
        player = new Player(playerName);
    }

    private static void gameLoop() {
        while (isRunning) {
            // Aqui você pode adicionar a lógica do jogo, como combates, exploração, etc.
            int choice = JOptionPane.showOptionDialog(null, "Você se depara com um inimigo! O que deseja fazer?", 
                                                     "Combate", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                     null, new Object[]{"Atacar", "Fugir"}, "Atacar");

            if (choice == 0) {
                gameWindow.displayText("Você ataca o inimigo!");
                // Aqui poderia estar a lógica de combate
            } else if (choice == 1) {
                gameWindow.displayText("Você foge da batalha...");
                isRunning = false;
            }

            // Exemplo de como parar o jogo após uma rodada
            int playAgain = JOptionPane.showConfirmDialog(null, "Deseja continuar jogando?", "Continuar?", JOptionPane.YES_NO_OPTION);
            if (playAgain != JOptionPane.YES_OPTION) {
                isRunning = false;
            }
        }

        gameWindow.displayText("Obrigado por jogar!");
    }
}

// Classe para a janela principal do jogo
class GameWindow extends JFrame {

    private JTextArea textArea;

    public GameWindow() {
        setTitle("DEAD CITY");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
    }

    public void displayText(String text) {
        textArea.append(text + "\n");
    }
}

// Classe do jogador
class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Classe da história do jogo
class Story {
    public static void printIntro(GameWindow gameWindow) {
        gameWindow.displayText("Bem-vindo à DEAD CITY, " + GameGUI.playerName + "!");
        gameWindow.displayText("Você está em uma cidade desolada, cheia de perigos e mistérios.");
    }

    public static void printFirstActIntro(GameWindow gameWindow) {
        gameWindow.displayText("O primeiro ato começa agora...");
        gameWindow.displayText("Você sente uma presença sinistra ao seu redor...");
    }
}