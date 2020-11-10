package com.myCompenent;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyButtonCellRender extends DefaultTableCellRenderer {
	private JButton button = null;
	
	public MyButtonCellRender(String name) {
		// TODO Auto-generated constructor stub
		button = new JButton(name);
		button.setFont(new Font("����", Font.PLAIN, 14));
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		setForeground(table.getSelectionForeground());
		setBackground(table.getSelectionBackground());
		
		return button;
	}
	
}
