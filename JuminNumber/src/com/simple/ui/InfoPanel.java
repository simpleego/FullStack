package com.simple.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InfoPanel extends JPanel {
	
	JTextField tfID1, tfID2, tfName;
	JLabel lblID, lbl_, lblName;
	
	Color gray = null;
	Font font = null;

	public InfoPanel(Color gray, Font font) {

		this.gray = gray;
		this.font = font;
		
		//상하좌우 10씩 띄우기
		this.setBorder(BorderFactory.createEmptyBorder(20 , 20 , 20 , 20)); 
		
		this.setLayout(new GridLayout(0, 4,20,20));
		this.setBackground(gray);
		this.setPreferredSize(new Dimension(660,150));
		tfID1 = new JTextField(6); 
		tfID1.setFont(font);
		tfID1.setHorizontalAlignment(JTextField.CENTER);
		tfID2 = new JTextField();
		tfID2.setFont(font);
		tfID2.setHorizontalAlignment(JTextField.CENTER);
		tfName = new JTextField();
		tfName.setFont(font);
		tfName.setHorizontalAlignment(JTextField.CENTER);
		
		lblID = new JLabel("주민번호 : ", JLabel.RIGHT);
		lblID.setFont(font);
		lblName = new JLabel("이 름 : ", JLabel.RIGHT);
		lblName.setFont(font);
		lbl_ = new JLabel(" - ", JLabel.CENTER);
		lbl_.setFont(font);
		
		
		add(lblID);
		add(tfID1);
		add(lbl_);
		add(tfID2);
		
		add(lblName);
		add(tfName);
		
	}
}
