package tablelist;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class KCBData implements TableModel {
	private String[] title = {
			"��һ","�ܶ�","����","����","����"
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
		// TODO �Զ����ɵķ������
		return 8;
	}

	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO �Զ����ɵķ������
		return title[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO �Զ����ɵķ������
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		return data[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		data[rowIndex][columnIndex] = (String)aValue;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO �Զ����ɵķ������

	}

}