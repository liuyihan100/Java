package code1;

public class CD extends Item{
	private String artist;
	private int numofTracks;
	
	public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
		super(title,playingTime,comment);
		this.artist = artist;
		this.numofTracks = numofTracks;
	}
	
	
	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numofTracks=" + numofTracks + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO �Զ����ɵķ������
		CD cd = (CD)obj;
		return artist.equals(cd.artist);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
	public void print() {
		// TODO �Զ����ɵķ������
		super.print();
		System.out.println(artist);
	}

}