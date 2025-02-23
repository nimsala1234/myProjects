import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//Frontend
//we need to implement the ActionListener interface to the class to be able to listen to the button presses
public class GUI extends JFrame implements ActionListener{
    //player buttons
    //create the buttons as global varibales because later on we are adding event listeners to these buttons
    JButton rockButton, paperButton, scissorButton;
    //will display the choice of the computer and made it a global varibale cause we have to access it in our method showDialog
    JLabel computerChoice;

    //display score of computer and player
    JLabel computerScoreLabel, playerScoreLabel;

    //backend obj
    RockPaperScissor rockPaperScissor;

    public GUI(){
        setTitle("Hand Wars");
        setSize(450, 574);

        //set layout to null to disable layout management. So we can use absolute positions for the elements.
        setLayout(null); 

        //terminate the java virtual machine when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Load the GUI in the center of the screen
        setLocationRelativeTo(null);   

        //initialize the backend obj
        rockPaperScissor = new RockPaperScissor();

        //add GUI components
        addGUIComponents();
    }

    private void addGUIComponents(){
        //create computer score label
        computerScoreLabel = new JLabel("Computer: 0");

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
        computerChoice = new JLabel("?"); 
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(computerChoice);

        //create player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 38);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons
        //rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
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
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //reset computer choice
                computerChoice.setText("?");
                //close the dialog box
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);


    }

    //this will be called when a GUI component that has their action listener set to our class is activated
    @Override
    public void actionPerformed(ActionEvent e) {
        // get player choice
        String playerChoice = e.getActionCommand().toString();

        //play rock paper scissor and store result into string variable
        //here we are calling into our playRockPaperScissor() method in our backend class
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        //load computer's choice
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        //update scores
        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

        //display result
        showDialog(result);
    }
}