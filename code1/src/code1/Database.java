package code1;

import java.util.ArrayList;

public class Database {
	private ArrayList<Item> cdnames = new ArrayList<Item>();
	
	public void add(Item item) {
		cdnames.add(item);
	}
	
	public void list() {
		for(Item item : cdnames)
			item.print();
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Database it = new Database();
		CD cd = new CD("������", "�ܽ���", 11, 60, "�����ȵ��������������㡷����һ������������ˬ��");
		DVD dvd = new DVD("���֮��", "���鿥", 90, "��Ƭ�����������˹���Ůϣ��������³�Լ����������ӡ���˹����Ѱ�����֮�����մLaputa�������ռǡ�");
		CD cc = new CD("������", "�ܽ���", 11, 60, "��ϲ��");
		System.out.println(cd.equals(cc));
		it.add(cd);
		it.add(dvd);
		it.list();
	}

}