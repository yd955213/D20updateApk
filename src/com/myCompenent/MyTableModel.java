package com.myCompenent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class MyTableModel extends DefaultTableModel {

	public MyTableModel() {
		
	}
	
	public MyTableModel(Object[][] data,Object[] columnnames)  {
		super(data,columnnames);
	}
	public Class<?> getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}  
	
	public boolean isCellEditable(int row ,int column) {
		Class columnClass = getColumnClass(column);
		return columnClass == JCheckBox.class || columnClass == java.lang.Boolean.class;
	}
	
//	@Override
//	public boolean isCellEditable(int row, int column) {
//		// TODO Auto-generated method stub
//		return super.isCellEditable(row, column);
//	}
//
//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		// TODO Auto-generated method stub
//		return super.getColumnClass(columnIndex);
//	}

}
