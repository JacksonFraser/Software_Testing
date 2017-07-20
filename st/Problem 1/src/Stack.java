// A simple Stack class for testing with

class Stack {
	int[] values;
	int count;
	
	public Stack() {
		this.values = new int[10];
		this.count = 0;
	}
	
	public Stack(int size) {
		this.values = new int[size];
		this.count = 0;
	}
	
	// insert a new value onto the stack
	public void push(int item) throws Overflow {
		if (this.count < this.values.length) {
			this.values[count] = item;
			count++;
		} else {
			throw new Overflow("Stack overflowed");
		}
	}
	
	// remove the top item, and return it
	public int pop() throws Underflow {
		if (this.count > 0) {
			int item = this.values[count-1];
			count--;
			return item;
		} else {
			throw new Underflow("Stack underflowed");
		}
	}
	
	// remove all items from the stack
	public void clear() {
		this.count = 0;
	}
	
	// return the item at the top of the stack
	public int peek() throws Underflow {
		if (this.count >= 0) {
			return this.values[count];
		} else {
			throw new Underflow("Stack underflowed");
		}
	}
	
	public int size() {
		return this.count;
	}
	public int valuesSize(){
		return this.values.length;
	}
	
	public boolean contains(int elemnt){
		for(int i : values){
			if(i == elemnt){
				return true;
			}
		}
		
		return false;
	}
	
}