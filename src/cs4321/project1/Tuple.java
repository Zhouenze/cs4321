package cs4321.project1;


/**
 * This is a helper class created to represent the operator and its currently
 * needed operands
 * @author Weicheng Yu wy248
 */

public class Tuple {
	private int counter;
	private final int init_count; // need init_count to determine number of pops
	private final char op;
	
	
	/**
	* Constructor that initializes variables
	*
	* @param count: needed operands
	* @param operation: +/-*~
	*/
	public Tuple(int count, char operation){
		this.init_count = count;
		this.counter = count;
		this.op = operation;
	}
	
	/**
	* method to update counter
	*
	* @param val: update counter by val
	* 
	*/
	public void addCounter(int val) {
		counter += val;
	}
	
	/**
	* getter for counter
	*
	* 
	* @return counter 
	*/
	public int getCounter() {
		return counter;
	}
	
	/**
	* getter for init_count
	*
	* 
	* @return init_count
	*/
	public int getInitCount(){
		return init_count;
	}
	
	/**
	* getter to get operation type
	*
	* @return operation type
	* 
	*/
	public char getOp(){
		return op;
	}
}
