import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class NumberGuessingGame extends JFrame implements ActionListener {
    private JTextField guessField;
    private JButton submitButton;
    private JLabel resultLabel;
    private int randomNumber;
    private int attempts;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel promptLabel = new JLabel("Guess a number between 1 and 100:");
        add(promptLabel);

        guessField = new JTextField(10);
        add(guessField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        resultLabel = new JLabel(" ");
        add(resultLabel);

        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attempts = 0;

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            attempts++;
            if (userGuess < 1 || userGuess > 100) {
                resultLabel.setText("Please enter a number between 1 and 100.");
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                resultLabel.setText("Too high! Try again.");
            } else {
                resultLabel.setText("Correct! You guessed it in " + attempts + " attempts.");
                submitButton.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input! Please enter a number.");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
