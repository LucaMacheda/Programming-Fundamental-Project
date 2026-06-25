import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();

        setTitle("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        lblStatus = new JLabel("Your turn (X)", SwingConstants.CENTER);
        add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[9];

        Font buttonFont = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(buttonFont);

            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));

            boardPanel.add(buttons[i]);
        }

        add(boardPanel, BorderLayout.CENTER);
    }

    private void handlePlayerMove(int index) {
        boolean moveSuccess = gameLogic.makeMove(index, 'X');

        if (!moveSuccess) {
            JOptionPane.showMessageDialog(this, "Invalid move!");
            return;
        }

        buttons[index].setText("X");
        buttons[index].setEnabled(false);

        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Computer turn (O)");

        int computerIndex = gameLogic.computerMove();

        if (computerIndex != -1) {
            buttons[computerIndex].setText("O");
            buttons[computerIndex].setEnabled(false);
        }

        if (gameLogic.checkWinner('O')) {
            finishGame("LOSE");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Your turn (X)");
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        JOptionPane.showMessageDialog(this, "Game result: " + result);

        Player updatedPlayer = playerService.getPlayerById(currentPlayer.getId());
        if (updatedPlayer != null) {
            currentPlayer = updatedPlayer;
        }

        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}
