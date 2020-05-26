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
		// TODO 自动生成的方法存根
		Database it = new Database();
		CD cd = new CD("七里香", "周杰伦", 11, 60, "在炎热的夏天听《七里香》，有一种如沐清风的凉爽。");
		DVD dvd = new DVD("天空之城", "宫崎骏", 90, "该片讲述的是主人公少女希达和少年巴鲁以及海盗、军队、穆斯卡等寻找天空之城拉普达（Laputa）的历险记。");
		CD cc = new CD("七里香", "周杰伦", 11, 60, "我喜欢");
		System.out.println(cd.equals(cc));
		it.add(cd);
		it.add(dvd);
		it.list();
	}

}