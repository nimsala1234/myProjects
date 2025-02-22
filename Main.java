//App class
import javax.swing.*;

public class Main{
    public static void main(String[] args){
        //Use this to allow our GUI to be created and updated in a thread-safe manner.
        //It helps prevent potential race conditions and maintains the responsiveness of th
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                //instantiate a GUI obj
                GUI gui = new GUI();

                //display the GUI
                gui.setVisible(true);
            }
        });
    }
}