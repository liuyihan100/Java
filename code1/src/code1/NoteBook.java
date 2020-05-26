package code1;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<String> note = new ArrayList<String>();
	
	public void add(String s) {
		note.add(s);
	}
	
	public void add(String s,int index) {
		note.add(index,s);
	}
	
	public int getSize() {
		return note.size();
	}
	
	public String getNote(int index) {
		return note.get(index);
	}
	
	public void remove(int index) {
		note.remove(index);
	}
	
	public String[] list() {
		String[] a = new String[note.size()];
		note.toArray(a);
		return a;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		NoteBook nb = new NoteBook();
		nb.add("刘毅晗");
		nb.add("周杰伦");
		nb.add("青い",0);
		System.out.println(nb.getSize());
		System.out.println(nb.getNote(1));
		for(String s:nb.list()) {
			System.out.println(s);
		}
	}

}