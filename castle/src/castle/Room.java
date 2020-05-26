package castle;

import java.util.HashMap;

public class Room {
	private String description;
	private HashMap<String, Room> exits = new HashMap<String, Room>();
	
	public Room(String description) {
		this.description = description;
	}
	
	public void setExits(String direction,Room room) {
		exits.put(direction, room);
	}
	
	public String getExitsDesc() {
		StringBuffer desc = new StringBuffer();
		for(String dir : exits.keySet()) {
			desc.append(dir);
			desc.append(" ");
		}
		return desc.toString();
	}
	
	public Room getExit(String direction) {
		return exits.get(direction);
	}
	
	@Override
	public String toString() {
		return description;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}