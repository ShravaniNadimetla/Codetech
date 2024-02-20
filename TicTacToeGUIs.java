//Task 1
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUIs implements ActionListener {

    private JFrame frame;
    private JButton[][] buttons;
    private JLabel messageLabel;

    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;

    public TicTacToeGUIs() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
                board[i][j] = ' ';
            }
        }

        messageLabel = new JLabel("Player " + currentPlayer + "'s turn");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            return;
        }

        JButton clickedButton = (JButton) e.getSource();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == clickedButton && board[i][j] == ' ') {
                    board[i][j] = currentPlayer;
                    clickedButton.setText(String.valueOf(currentPlayer));

                    if (checkForWin()) {
                        messageLabel.setText("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    } else if (isBoardFull()) {
                        messageLabel.setText("It's a draw!");
                        gameOver = true;
                    } else {
                        switchPlayer();
                        messageLabel.setText("Player " + currentPlayer + "'s turn");
                    }
                }
            }
        }
    }

    private boolean checkForWin() {
        // Implement the win condition checking logic from the original code here
        // Return true if there is a winner, false otherwise
        return false;
    }

    private boolean isBoardFull() {
        // Implement the board full condition checking logic from the original code here
        // Return true if the board is full, false otherwise
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeGUIs::new);
    }
}
