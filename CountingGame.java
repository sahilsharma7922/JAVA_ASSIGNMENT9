import java.io.*;
import java.util.*;

/**
 * CountingGame is a program that will simulate a children's counting game used to select
 * someone.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
    
public class CountingGame
{

    public static void main(String args[])
    {
        ListInterface<Integer> players = null;
        ListInterface<String> rhyme = null;
        
        int max;
        int position = 1;       // always start with the first player
        
        System.out.println("Please enter the number of players.");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        System.out.println("Constructing list of players");
        
        // ADD CODE HERE TO CREATE THE LIST OF PLAYERS
        	//the list is reinitialized with object of type AList. 
        players=new AList<Integer>();
        
        	//initializing the Players List
		for(int count=1;count<=max;count++){
			players.add(count);
		}
		
        
        rhyme = getRhyme();

        // ADD CODE HERE TO PLAY THE GAME
        
	        //call doRhyme()
	        //starting position is 1.
        doRhyme(players,rhyme,position);

        	//priting Out result.
        System.out.println("The winner is " + players.getEntry(1));
    }
    
    
    /**
     * Do the rhyme with the players in the list and remove the selected
     * player.
     *
     * @param  players   A list holding the players.
     * @param  rhyme   A list holding the words of the rhyme.
     * @param  startAt A position to start the rhyme at.
     * 
     * @return The position of the player eliminated.
     */
   public static int doRhyme(ListInterface<Integer> players, ListInterface<String> rhyme, int startAt)
    {
        // COMPLETE THIS METHOD
	   
	   int playerPlaying=0;
	   
	   		//If there is just one element in the players List
	   if(players.getLength()==1)
		   return 1;
	   
	   		//getLength() and getEntry are defined in the List ADT and are used for getting the entries and a particular entry
	   
	   
	   		//The Loop runs words in rhyme number of times
	   for(int i=0;i<rhyme.getLength();i++) {
		   		//The Current Playing Player
		   playerPlaying=startAt%players.getLength();
		   		//For Modulus when last player playing
		   if(playerPlaying==0)
			   playerPlaying=players.getLength();
		   System.out.println("Player "+players.getEntry(playerPlaying)+": "+rhyme.getEntry(i+1));
		   startAt++;
	   }
	   
	   System.out.println("Removing Player "+players.getEntry(playerPlaying));
	   		//Removing Player from List
	   players.remove(playerPlaying);
	   
	   		//Recursive call to doRhyme Function with original-1 elements
	   doRhyme(players,rhyme,playerPlaying);
	   
        return 1;

     }
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }
    
    /**
     * getRhyme - Get the rhyme.
     *
     * @return    A list of words that is the rhyme.
     */
    private static ListInterface<String> getRhyme()
    {
        Scanner input;
        String inString = "";
        ListInterface<String> rhyme = new AList<String>();
        
        try
        {
            input = new Scanner( System.in );
            
            System.out.println("Please enter a rhyme");
            inString = input.nextLine().trim();
            
            Scanner rhymeWords = new Scanner(inString);
            while(rhymeWords.hasNext())
            {
                rhyme.add(rhymeWords.next());
            }
            
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use a rhyme of size one");
        }

        // Make sure there is at least one word in the rhyme
        if(rhyme.getLength() < 1)
            rhyme.add("Default");
            
        return (ListInterface<String>)rhyme;
                                    
    }
    
}
