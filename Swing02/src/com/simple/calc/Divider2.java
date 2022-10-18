package com.simple.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Divider2 implements ActionListener{
	IndependentEvent ui;
	
	public Divider2(IndependentEvent ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ³ª´°¼À ¼öÇà
		int num1 = Integer.parseInt(ui.tfName.getText());
		int num2 = Integer.parseInt(ui.tfName1.getText());
		double result = num1/ (double)num2;
		ui.tfNameOut.setText(String.format("%.2f", result));		
	}

}
