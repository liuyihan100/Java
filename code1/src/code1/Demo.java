package code1;

public class Demo {
	int i;
	
	public Demo(int i) {
		this.i = i;
	}

	public void set(int i) {
		this.i = i;
	}
	
	public int get() {
		return i;
	}
	
	public String toString() {
		return (""+i);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Demo i = new Demo(5);
		System.out.println(i);
	}

}