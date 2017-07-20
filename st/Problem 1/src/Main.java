public class Main {
	public static void main(String[] args) {
		Stack s = new Stack();
		try{
			s.push(1);
			int n = s.size();
			s.push(5);
			int v = s.size();
			System.out.println(n);
			System.out.println(v);
		}catch(Overflow e){
			
		}
	}
}
