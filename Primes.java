import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        // COMPLETE THE MAIN
        
	        //Declaring 3 lists: 1. Candidates.
	        //					 2. Primes.
	        //					 3. Composites.
        
        ListInterface<Integer> candidates=new AList<Integer>();
        ListInterface<Integer> primes=new AList<Integer>();
        ListInterface<Integer> composites=new AList<Integer>();
        
        
        	//initialize the candidates
        
        for(int number=2;number<=max;number++){
			candidates.add(number);
		}
        
        	//Have a look at the candidates
        System.out.println("Initial Candidates: "+candidates);
        
        	//The loop shall run uptil the candidate list is empty
        while(candidates.getLength()!=0) {
        		//Remove the first element of candidate
        	int primeElement=candidates.remove(1);
        		//Check for its multiples
        	getComposites(candidates,composites,primeElement);
        		//Save that in Primes List
        	primes.add(primeElement);
        }
        
        	//Print out Composites and Primes after segregation
        System.out.println("Composites: "+composites+"\nPrimes: "+primes);
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        // COMPLETE THIS METHOD
    	
    		//get initial length of candidate. It will be zero if candidate has nothing.
    	int length=candidates.getLength();
    	
    		//If candidate list is empty the loop shall not run
    	for(int index=1;index<=length;index++) {
    		
    		if(candidates.getEntry(index)%prime==0) {
    			composites.add(candidates.remove(index));
	    			/*Remove Element from candidate and put it in Composites.
	    			Decrement the index and length of candidate*/
    			index--;
    			length--;
    		}
    		
    	}
    	
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
    
}
