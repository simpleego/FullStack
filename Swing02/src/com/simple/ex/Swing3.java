package com.simple.ex;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing3 extends JFrame {
	JButton btn, btn1;

	public Swing3() {
		
		// ������ �ʱ� ����
		setTitle("������01");
		setSize(400, 500);// ���� ���� ũ��
		// ������ ��ġ ����
		setLayout(null);
		// ������Ʈ ��ġ�� ���� ����(��ġ,ũ��)

		// ���ϴ� ������Ʈ ����
		// ��ư ����
		btn = new JButton("������");
		btn.setBounds(100, 100, 100, 40);

		btn1 = new JButton("������");
		btn1.setBounds(210, 100, 100, 40);

		// �����ӿ� ������Ʈ ���
		add(btn);
		add(btn1);

		// ������ Ȱ��ȭ(������ ���̰�)
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Swing3();
		//Swing3 f2 = f1;

	}

}
