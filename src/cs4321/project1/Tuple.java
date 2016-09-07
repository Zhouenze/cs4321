package cs4321.project1;

public class Tuple {
	private int counter;
	private final int init_count;
	private final char op;
	
	public Tuple(int count, char operation){
		this.init_count = count;
		this.counter = count;
		this.op = operation;
	}
	
	public void addCounter(int val) {
		counter += val;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public int getInitCount(){
		return init_count;
	}
	
	public char getOp(){
		return op;
	}
}
