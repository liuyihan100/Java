package tablelist;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class KCBData implements TableModel {
	private String[] title = {
			"周一","周二","周三","周四","周五"
	};
	private String[][] data = new String[8][5];
	
	public KCBData() {
		for(int i = 0;i < data.length;i++) {
			for(int j = 0;j < data[i].length;j++)
				data[i][j] = "";
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return 8;
	}

	@Override
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO 自动生成的方法存根
		return title[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO 自动生成的方法存根
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO 自动生成的方法存根
		return data[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO 自动生成的方法存根
		data[rowIndex][columnIndex] = (String)aValue;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO 自动生成的方法存根

	}

}