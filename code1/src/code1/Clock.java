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
		// TODO �Զ����ɵķ������
		Clock clock = new Clock();
		clock.Start();
	}

}