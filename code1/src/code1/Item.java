package code1;

public class Item {
	private String title;
	private boolean gotIt;
	private String comment;
	private int palyingTime;
	
	
	public Item(String title,  int palyingTime,  String comment) {
		super();
		this.title = title;
		this.comment = comment;
		this.palyingTime = palyingTime;
	}
	public void print() {
		System.out.println(title);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}