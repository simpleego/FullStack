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

public class ResultPanel extends JPanel {
	
	JTextField tfResult;
	JLabel lblResult;
	
	Color gray = null;
	Font font = null;

	public ResultPanel(Color gray, Font font) {

		this.gray = gray;
		this.font = font;
		
		//상하좌우 10씩 띄우기
		this.setBorder(BorderFactory.createEmptyBorder(20 , 20 , 20 , 20)); 
		
		this.setLayout(new GridLayout(0, 4,20,20));
		this.setBackground(gray);
		this.setPreferredSize(new Dimension(660,80));
		
		lblResult = new JLabel("결 과 : ", JLabel.RIGHT);
		font = new Font("굴림체", Font.BOLD, 18);
		lblResult.setFont(font);
		tfResult = new JTextField(20);
		tfResult.setFont(font);	
		tfResult.setHorizontalAlignment(JTextField.CENTER);
		
		add(lblResult);
		add(tfResult);
		
	}
}
