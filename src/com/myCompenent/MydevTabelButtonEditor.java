package com.myCompenent;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MydevTabelButtonEditor extends DefaultCellEditor{
	
	private JButton button = null;
	private int row1;
	public MydevTabelButtonEditor(String name) {
		super(new JTextField());
		this.setClickCountToStart(1);  
		// TODO Auto-generated constructor stub
		button = new JButton(name);
		button.setFont(new Font("����", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				MydevTabelButtonEditor.this.fireEditingCanceled();  
//				DefaultTableModel devTableModel = (DefaultTableModel) IPconfig.devTable.getModel();
////				System.out.println(row1);
////				vt.add(((Vector)devTableModel.getDataVector().elementAt(row1)).elementAt(2)+"");
//				String mac = (String)((Vector)devTableModel.getDataVector().elementAt(row1)).elementAt(2);
////				System.out.println(mac);
//				String[] row = {mac ,null};
//				devTableModel.removeRow(row1);
//				DefaultTableModel tableModel2 = (DefaultTableModel) IPconfig.macTable.getModel();
////				vt.add(button);
//				tableModel2.addRow(row);
//				if(Protocol.getMacFilter().indexOf(mac) == -1) {
//					Protocol.getMacFilter().add(mac);
//				} 
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		this.row1 = row; 
        return button;
	}
}
