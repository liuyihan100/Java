package code1;

public class Clock {
	private Display2 minute = new Display2(60);
	private Display2 hour = new Display2(24);
	
	public void Start() {
		while(true) {
			minute.increase();
			if(minute.getvalue() == 0) {
				hour.increase();
			}
			System.out.printf("%02d:%02d\n",hour.getvalue(),minute.getvalue());
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Clock clock = new Clock();
		clock.Start();
	}

}