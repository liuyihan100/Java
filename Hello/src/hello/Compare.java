package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Compare {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Compare m = new Compare();
		m.go();
	}
	
	public void go() {
		ArtListCompare compare = new ArtListCompare();
		Song s1 = new Song("a");
		Song s2 = new Song("b");
		ArrayList<Song> list = new ArrayList<Compare.Song>();
		list.add(s2);
		list.add(s1);
		System.out.println(list);
		Collections.sort(list,compare);
		System.out.println(list);
	}
	
	public class Song{
		private String title;
		
		public Song(String title) {
			this.title = title;
		}
		
		public String getTitle() {
			return title;
		}
		
		public String toString() {
			return title;
		}
	}
	
	public class ArtListCompare implements Comparator<Song>{

		@Override
		public int compare(Song o1, Song o2) {
			// TODO 自动生成的方法存根
			return o1.getTitle().compareTo(o2.getTitle());
		}
		
	}
}