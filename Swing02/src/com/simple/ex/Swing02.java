package com.simple.ex;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing02 {
	
	public static void main(String[] args) {
		
		JButton btn, btn1;

		JFrame win = new JFrame();
		
		// ������ �ʱ� ����
		win.setTitle("������01");
		win.setSize(400,500);// ���� ���� ũ��
		// ������ ��ġ ����
		win.setLayout(null);
		// ������Ʈ ��ġ�� ���� ����(��ġ,ũ��)
		
		// ���ϴ� ������Ʈ ����
		// ��ư ����
		btn = new JButton("������");
		btn.setBounds(100, 100, 100, 40);
		
		btn1 = new JButton("������");
		btn1.setBounds(210, 100, 100, 40);
		
		// �����ӿ� ������Ʈ ���
		win.add(btn);
		win.add(btn1);		
		
		// ������ Ȱ��ȭ(������ ���̰�)
		win.setResizable(false);
		win.setVisible(true);
		
	}

}
