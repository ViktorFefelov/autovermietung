package dbaccess.ui;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbaccess.core.Mieter;

public class MieterTableModel extends AbstractTableModel{

	private static final int MID_COL = 0;
	private static final int MNAME_COL = 1;
	private static final int MSTRASSE_COL = 2;
	private static final int MPLZ_COL = 3;
	private static final int MORT_COL = 4;
	private static final int MTEL_COL = 5;
	
	private String[] columnNames = {"mid", "mname", "mstrasse", "mplz", "mort", "mtel"};
	private List <Mieter> mieter;
	
	public MieterTableModel(List <Mieter> cmieter) {
		mieter = cmieter;
	}

	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	
	public String[] getcolumnNames() {
		return columnNames;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return mieter.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		//return super.getColumnClass(columnIndex);
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Mieter m = mieter.get(row);
		
		switch (col){
		case MID_COL:
			return m.getMid();
		case MNAME_COL:
			return m.getMname();
		case MSTRASSE_COL:
			return m.getMstrasse();
		case MPLZ_COL:
			return m.getMplz();
		case MORT_COL:
			return m.getMort();
		case MTEL_COL:
			return m.getMtel();
		default:
			return m.getMid();
		}
	}
}
