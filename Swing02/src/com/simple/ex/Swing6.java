package com.simple.ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Swing6 extends JFrame implements ActionListener {
	JButton btn, btn1;
	JTextField tfName, tfName1, tfNameOut;
	JLabel lblName, lblName1;
	private JButton btnMinus;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnAdd;

	public Swing6() {

		// ������ �ʱ� ����
		this.setTitle("������01");
		setSize(400, 500);// ���� ���� ũ��
		// ������ ��ġ ����
		setLayout(null);
		// ������Ʈ ��ġ�� ���� ����(��ġ,ũ��)

		// ���ϴ� ������Ʈ ����
		// Ű���� �Է� ������Ʈ JTextField
		lblName = new JLabel("����1 : ");
		lblName.setBounds(50, 5, 100, 40);

		lblName1 = new JLabel("����2 : ");
		lblName1.setBounds(50, 50, 100, 40);

		tfName = new JTextField();
		tfName.setBounds(100, 5, 100, 40);

		tfName1 = new JTextField();
		tfName1.setBounds(100, 50, 100, 40);

		tfNameOut = new JTextField();
		tfNameOut.setBounds(100, 150, 100, 40);

		// ��ư ����
		ImageIcon img1 = new ImageIcon("plus.png");
		btn = new JButton(img1);
		btn.setBounds(100, 100, 50, 40);
		btn.addActionListener( (ActionEvent e)->{
			int add=0;
			String num1 = tfName.getText();
			String num2_ = tfName1.getText();
			int num2 = Integer.parseInt(num2_);
			add = Integer.parseInt(num1) + num2;
			tfNameOut.setText(add + "");
		});

		// ���� ��ư
		btnMinus = new JButton("-");
		btnMinus.setBounds(150, 100, 50, 40);
		btnMinus.addActionListener(this);

		// ���� ��ư
		btnMul = new JButton("x");
		btnMul.setBounds(200, 100, 50, 40);
		btnMul.addActionListener(new Multiply());

		// ������ ��ư
		btnDiv = new JButton("/");
		btnDiv.setBounds(250, 100, 50, 40);
		btnDiv.addActionListener(new Divide(this));

		// �����ӿ� ������Ʈ ���
		add(btn);
		add(btnMinus);
		add(btnMul);
		add(btnDiv);
		add(tfName);
		add(tfName1);
		add(tfNameOut);
		add(lblName);
		add(lblName1);

		// ������ Ȱ��ȭ(������ ���̰�)
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		Swing6 win = new Swing6();
		// Swing3 f2 = f1;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Ű���� �Է� ���� �о����
		String num1 = tfName.getText();
		String num2 = tfName1.getText();
		int result=0;
		if(e.getSource() == btnMinus) {
			result = Integer.parseInt(num1) - Integer.parseInt(num2);			
		}	
		tfNameOut.setText(result + "");		
	}
	
	public void sqrt() {
		System.out.println("������ ���");
	}
	
	private class Multiply implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// 
			String num1 = tfName.getText();
			String num2 = tfName1.getText();
			int result=0;
				result = Integer.parseInt(num1) 
						* Integer.parseInt(num2);
			tfNameOut.setText(result + "");
			sqrt();
		}
		
	}

}
