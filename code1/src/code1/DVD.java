package code1;

public class DVD extends Item{

		private String director;
		
		public DVD(String title, String director, int playingTime, String comment) {
			super(title,playingTime,comment);
			this.director = director;

		}
		
		public void print() {
			// TODO �Զ����ɵķ������
			super.print();
			System.out.println(director);
		}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}