import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
//Frontend

public class GUI extends JFrame{
    //player buttons
    //create the buttons as global varibales because later on we are adding event listeners to these buttons
    JButton rockButton, paperButton, scissorButton;

    public GUI(){
        setTitle("Hand Wars");
        setSize(450, 574);

        //set layout to null to disable layout management. So we can use absolute positions for the elements.
        setLayout(null); 

        //terminate the java virtual machine when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Load the GUI in the center of the screen
        setLocationRelativeTo(null);   

        //add GUI components
        addGUIComponents();
    }

    private void addGUIComponents(){
        //create computer score label
        JLabel computerScoreLabel = new JLabel("Computer: 0");

        //set x,y coordinates and width/height values
        computerScoreLabel.setBounds(0,43,450, 30);

        //set the font to have a font family of dialog, font-weight of bold, and a font size of 26
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        //place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(computerScoreLabel);

        //create computer choice
        //set the default as "?" so we can hide computer's choice after every new match
        JLabel computerChoice = new JLabel("?"); 
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(computerChoice);

        //create player score label
        JLabel playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 38);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons
        //rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(rockButton);

        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(paperButton);

        //scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(scissorButton);
    }

    //add a dialog to display the result of the match and a try again button to play again
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result", true);
        //modal referts to a property of a dialog that rewuires user's immediate attention & blocks input to anything else before its closed
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message lable
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        

    }
}