package com.simple.ex;

import java.awt.Button;
import java.awt.Frame;

public class AWTExam extends Frame{
	
	public AWTExam() {
		// TODO Auto-generated constructor stub
		setSize(300,300);// ������ ������
		setTitle("ó�� ���� ������");
		Button b = new Button("Ŭ��");
		// ��ư ������
		b.setBounds(10, 100, 100, 30);
		
		add(b);
		
		setLayout(null);
		
		setVisible(true);		
		
	}
	
	public static void main(String[] args) {
		new AWTExam();
	}	

}
