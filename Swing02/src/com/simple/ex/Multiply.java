package com.simple.ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multiply implements ActionListener {
	Swing6 win;
	
	public Multiply(Swing6 win) {
		this.win = win;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Ű���� �Է� ���� �о����
		long mul=0;
		String num1 = win.tfName.getText();
		String num2_ = win.tfName1.getText();
		int num2 = Integer.parseInt(num2_);
		if(num2 != 0) {
			 mul = Integer.parseInt(num1) * num2;					
		}
		win.tfNameOut.setText(mul+"");
	}

}
