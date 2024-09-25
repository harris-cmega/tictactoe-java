import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton [] buttons = new JButton[9];
    boolean player1_turn;
    int counter = 0;
    boolean hasWinner;

    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TicTacToe");
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255,0));
        textField.setFont(new Font("Roboto", Font.PLAIN, 50));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("Tic-Tac-Toe!");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150, 150, 150));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Roboto", Font.PLAIN, 70));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 9; i++){
            if (e.getSource() == buttons[i]){
                if (player1_turn){
                    if ((buttons[i].getText() == "")){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        counter++;
                        player1_turn = false;
                        textField.setText("O's turn");
                        checkX();
                    }
                } else {
                    if (buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        counter++;
                        player1_turn = true;
                        textField.setText("X's turn");
                        checkO();
                    }
                }

                if(counter == 9 && hasWinner == false){
                    textField.setText("Draw!");
                }
            }
        }
    }

    public void firstTurn(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        if(random.nextInt(2)==0){
            player1_turn = true;
            textField.setText("X turn");
        } else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void checkX(){
        // check to see if X completes the winning conditions
        if ((buttons[0]).getText().equals("X") && (buttons[1]).getText().equals("X") && (buttons[2]).getText().equals("X")) {
            xWins(0, 1, 2);
        }
        if ((buttons[3]).getText().equals("X") && (buttons[4]).getText().equals("X") && (buttons[5]).getText().equals("X")) {
            xWins(3, 4, 5);
        }
        if ((buttons[6]).getText().equals("X") && (buttons[7]).getText().equals("X") && (buttons[8]).getText().equals("X")) {
            xWins(6, 7, 8);
        }
        if ((buttons[0]).getText().equals("X") && (buttons[3]).getText().equals("X") && (buttons[6]).getText().equals("X")) {
            xWins(0, 3, 6);
        }
        if ((buttons[1]).getText().equals("X") && (buttons[4]).getText().equals("X") && (buttons[7]).getText().equals("X")) {
            xWins(1, 4, 7);
        }
        if ((buttons[2]).getText().equals("X") && (buttons[5]).getText().equals("X") && (buttons[8]).getText().equals("X")) {
            xWins(2, 5, 8);
        }
        if ((buttons[0]).getText().equals("X") && (buttons[4]).getText().equals("X") && (buttons[8]).getText().equals("X")) {
            xWins(0, 4, 8);
        }
        if ((buttons[2]).getText().equals("X") && (buttons[4]).getText().equals("X") && (buttons[6]).getText().equals("X")) {
            xWins(2, 4, 6);
        }

    }

    public void checkO(){
        // check to see if O completes the winning conditions
        if ((buttons[0]).getText().equals("O") && (buttons[1]).getText().equals("O") && (buttons[2]).getText().equals("O")) {
            oWins(0, 1, 2);
            System.out.println("0 won actually");
        }
        if ((buttons[3]).getText().equals("O") && (buttons[4]).getText().equals("O") && (buttons[5]).getText().equals("O")) {
            oWins(3, 4, 5);
        }
        if ((buttons[6]).getText().equals("O") && (buttons[7]).getText().equals("O") && (buttons[8]).getText().equals("O")) {
            oWins(6, 7, 8);
        }
        if ((buttons[0]).getText().equals("O") && (buttons[3]).getText().equals("O") && (buttons[6]).getText().equals("O")) {
            oWins(0, 3, 6);
        }
        if ((buttons[1]).getText().equals("O") && (buttons[4]).getText().equals("O") && (buttons[7]).getText().equals("O")) {
            oWins(1, 4, 7);
        }
        if ((buttons[2]).getText().equals("O") && (buttons[5]).getText().equals("O") && (buttons[8]).getText().equals("O")) {
            oWins(2, 5, 8);
        }
        if ((buttons[0]).getText().equals("O") && (buttons[4]).getText().equals("O") && (buttons[8]).getText().equals("O")) {
            oWins(0, 4, 8);
        }
        if ((buttons[2]).getText().equals("O") && (buttons[4]).getText().equals("O") && (buttons[6]).getText().equals("O")) {
            oWins(2, 4, 6);
        }
    }


    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        hasWinner = true;
        textField.setText("X wins!");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }

        hasWinner = true;
        textField.setText("O wins!");
    }
}
