package com.myCompenent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.MouseEvent;

public class myJButton extends JButton{
	private static JButton button;
	private static JLabel label;
	private static JPanel panel;
	private static boolean isclicked = false;
	public static boolean isIsclicked() {
		return isclicked;
	}
	
	public static void setIsclicked(boolean isclicked) {
		myJButton.isclicked = isclicked;
	}
	public myJButton(String name){
	        super(name);
	        initialize(name);
	    }
	 
    private void initialize(String name){
        setHorizontalAlignment(JButton.LEFT); 
        setHorizontalTextPosition(JButton.LEFT); 
        setVerticalTextPosition(JButton.BOTTOM); 
        setActionCommand(name); 
        addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("11111111111");
			}
		}); 
    }
}
