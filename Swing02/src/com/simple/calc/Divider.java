package com.simple.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.simple.ex.IndependentEvent2;

public class Divider implements ActionListener{
	IndependentEvent ui;	
	
	public Divider(IndependentEvent2 independentEvent2) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 
		int num1 = Integer.parseInt(ui.tfName.getText());
		int num2 = Integer.parseInt(ui.tfName1.getText());
		double result = num1+(double)num2;
		ui.tfNameOut.setText(String.format("%.2f", result));		
	}

}
