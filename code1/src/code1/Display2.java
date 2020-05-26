package code1;

public class Display2 {
	private int value = 0;
	private int limit = 0;
	
	public Display2(int limit) {
		this.limit = limit;
	}
	
	public void increase() {
		value++;
		if(value == limit)
			value = 0;
	}
	
	public int getvalue() {
		return value;
	}


	public static void main(String[] args) {
		
	}
}