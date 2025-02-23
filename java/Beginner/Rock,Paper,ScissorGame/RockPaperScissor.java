//handle the backend logic for rock paper scissors

import java.util.Random;

public class RockPaperScissor {
    //all of the choices that a computer can choose
    private static final String[] computerChoices= {"Rock", "Paper", "Scissor"};

    //store the computer choice, so that we can retrieve the value and display it to the frontend
    private String computerChoice;

    //store the scores so that we can retrieve them and display them at fronttend
    private int computerScore, playerScore;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    //use to generate a random number to randomly choose an option for the computer
    private Random random;

    //constructor to initialize random obj
    public RockPaperScissor(){
        random = new Random();
    }

    //method for handling a single game of rock paper scissor
    //call this method to begin playing rock paper scissor
    //playerChoice - the choice made by the player, this comes from frontend
    //this method will return the result of the game(computer wins, player wins, draw) 
    public String playRockPaperScissor(String playerChoice){
        //generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //will contain the returning message indicating the result of the game
        String result;

        //evaluate the winner
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player Wins!";
                playerScore++;
            }
            else if(playerChoice.equals("Scissor")){
                result = "Computer wins!";
                computerScore++;
            }
            else{
                result = "Draw!";
            }
        }
        else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissor")){
                result = "Player Wins!";
                playerScore++;
            }
            else if(playerChoice.equals("Rock")){
                result = "Computer wins!";
                computerScore++;
            }
            else{
                result = "Draw!";
            }
        }
        else{
            if(playerChoice.equals("Rock")){
                result = "Player Wins!";
                playerScore++;
            }
            else if(playerChoice.equals("Paper")){
                result = "Computer wins!";
                computerScore++;
            }
            else{
                result = "Draw!";
            }
        }

        return result;
    }
}
