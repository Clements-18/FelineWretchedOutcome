
import java.util.*;
/**
 * Class to keep track of the total score and number of frames in a bowling match. 
 * @author leah clements
 * @version 1.0;
 * @since 2020-10-30
 */
public class Bowling {
	private String theThrows;
	private Vector<Integer> inputVec = new Vector<>();
	private int totalPoints;
	private int frame;
	private int posInInputVec;

	public Bowling (String inputString) {
		this.theThrows = inputString;
		this.frame = 1;		
    this.totalPoints = 0;
		this.posInInputVec = 0;

		for (int i = 0; i < theThrows.length(); i++){
			char inptChar = this.theThrows.charAt(i);
			if (inptChar == '-'){
				continue;
			}
			else if (inptChar == 'X'){
				this.inputVec.add(10);
			}
			else if (inptChar == '/'){
				this.inputVec.add(10);
			}
			else {
				int nmbrValue = Character.getNumericValue(inptChar);
				this.inputVec.add(nmbrValue);
			}
		}
	}

/**
	 *
    score() uses values stored in my inptVector to calculate the match score.
	 */
	public int score(){
		int numthrows = 0;		
    int framescore = 0;

		
		for (int i = 0 ; i < this.theThrows.length(); i++){
			char inptChar = theThrows.charAt(i);
			if (this.frame == 10){
				if (inptChar == 'X'){
          frameTen(inptChar);
          break;
				}
				else if (inptChar == '/'){
 					frameTen(inptChar);
					break;
				}	
			}
			if (inptChar == '-'){ //end of the frame
				this.frame += 1;
				framescore = 0;
				numthrows = 0;
				continue;
			}
			else if (inptChar == '/'){//Isa spare
				numthrows += 1;
				spare();
				this.posInInputVec += 1;
			}			
      else if (inptChar == 'X'){ //Isa strike
				strike();
				this.posInInputVec += 1;

			}

			else{
				int nmbrValue = this.inputVec.get(this.posInInputVec);
				framescore += nmbrValue;
				numthrows += 1;
				if (framescore > 10){
					invalid();
          return 0;
				}
				if (numthrows > 2){
					invalid();
          return 0;
				}
				this.totalPoints += nmbrValue;
				this.posInInputVec += 1;
			}
		}
		if (this.frame > 10){
			invalid();
      return 0;
		}
	 prntScore();
   return this.totalPoints;
	}

/**
	 * strike() method gets data from the next 2 throws to calculate the value stored in the frame for a strike
	 */
	public void strike(){
		this.totalPoints += 10;
		int next1 = this.inputVec.get(this.posInInputVec + 1);
		int next2 = this.inputVec.get(this.posInInputVec + 2);
		this.totalPoints += (next1 + next2);
	
	}
/**
	 * spare() method recieves data from the next throw inorder to calculate the value stored in the frame for a spare
	 */
	public void spare(){
		int diff = 10 - this.inputVec.get(this.posInInputVec - 1);
		int next1 = this.inputVec.get(this.posInInputVec + 1);
		this.totalPoints += next1;
		this.totalPoints += diff;
	}
/**
	 * invalid() method tells the users their input Isinvalid then exits the program.
	 */
	public void invalid(){
    System.out.println("Input: String " + this.theThrows);
		System.out.println("Sorry! Invalid Input");
		
	}
/**
	 * prntScore() method shows the users string and the score of the string. 
	 */
	public void prntScore(){
		System.out.println("Input String: " + this.theThrows);
		System.out.println("Your Final Score: " + this.totalPoints);
	}
/**
	 * frameTen() calcuates the bonus score for spares and the strikes in the tenth frame.
	 */
	public void frameTen(char currthrow){
		if (currthrow == 'X'){
			this.totalPoints += 10;
			int next1 = this.inputVec.get(this.posInInputVec + 1);
			int next2 = this.inputVec.get(this.posInInputVec + 2);
			this.totalPoints += (next1 + next2);
		}
		else if (currthrow == '/'){
			int diff = 10 - this.inputVec.get(this.posInInputVec - 1);
			System.out.println(diff);
			this.totalPoints += diff;
			int next1 = this.inputVec.get(this.posInInputVec + 1);
			System.out.println(next1);
			this.totalPoints += next1;
	
		}
		else{
			int nmbrValue = this.inputVec.get(this.posInInputVec);
			this.totalPoints += nmbrValue;
		}
	}
}



