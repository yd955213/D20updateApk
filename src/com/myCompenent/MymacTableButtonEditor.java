package com.myCompenent;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.MissingFormatArgumentException;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MymacTableButtonEditor extends DefaultCellEditor{
	
	private JButton button = null;
	private int row1;
	public MymacTableButtonEditor(String name) {
		super(new JTextField());
		this.setClickCountToStart(1);  
		// TODO Auto-generated constructor stub
		button = new JButton(name);
		button.setFont(new Font("����", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				MymacTableButtonEditor.this.fireEditingCanceled();  
//				DefaultTableModel tableModel = (DefaultTableModel) IPconfig.macTable.getModel();
//				String mac = ((Vector)tableModel.getDataVector().elementAt(row1)).elementAt(0).toString();
////				System.out.println(mac);
////				System.out.println(mainInterface.getMacFilter().size());
//				Protocol.getMacFilter().remove(mac);
////				System.out.println(mainInterface.getMacFilter().size());
//				tableModel.removeRow(row1);
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
