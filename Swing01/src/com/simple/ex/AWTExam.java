package com.simple.ex;

import java.awt.Button;
import java.awt.Frame;

public class AWTExam extends Frame{
	
	public AWTExam() {
		// TODO Auto-generated constructor stub
		setSize(300,300);// 윈도우 사이즈
		setTitle("처음 만든 윈도우");
		Button b = new Button("클릭");
		// 버튼 사이즈
		b.setBounds(10, 100, 100, 30);
		
		add(b);
		
		setLayout(null);
		
		setVisible(true);		
		
	}
	
	public static void main(String[] args) {
		new AWTExam();
	}	

}
