import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;

    public StatisticsFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();

        setTitle("My Statistics");
        setSize(350, 250);
        setLocationRelativeTo(null);

        Player refreshedPlayer = playerService.getPlayerById(currentPlayer.getId());
        if (refreshedPlayer != null) {
            currentPlayer = refreshedPlayer;
        }

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username: " + currentPlayer.getUsername()));
        panel.add(new JLabel("Wins: " + currentPlayer.getWins()));
        panel.add(new JLabel("Losses: " + currentPlayer.getLosses()));
        panel.add(new JLabel("Draws: " + currentPlayer.getDraws()));
        panel.add(new JLabel("Score: " + currentPlayer.getScore()));

        add(panel, BorderLayout.CENTER);
    }
}
