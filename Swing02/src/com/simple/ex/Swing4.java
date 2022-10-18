package com.simple.ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Swing4 extends JFrame {
	JButton btn, btn1;
	JTextField tfName, tfName1, tfNameOut;
	JLabel lblName, lblName1;
	private JButton btnMinus;
	private JButton btnMul;
	private JButton btnDiv;

	public Swing4() {

		// ������ �ʱ� ����
		setTitle("������01");
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
		btn = new JButton("+");
		btn.setBounds(100, 100, 50, 40);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ű���� �Է� ���� �о����
				String num1 = tfName.getText();
				String num2 = tfName1.getText();
				int sum = Integer.parseInt(num1) + Integer.parseInt(num2);

				tfNameOut.setText(sum + "");
			}
		});

		// ���� ��ư
		btnMinus = new JButton("-");
		btnMinus.setBounds(150, 100, 50, 40);
		btnMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ű���� �Է� ���� �о����
				String num1 = tfName.getText();
				String num2 = tfName1.getText();
				int sub = Integer.parseInt(num1) - Integer.parseInt(num2);

				tfNameOut.setText(sub + "");
			}
		});

		// ���� ��ư
		btnMul = new JButton("x");
		btnMul.setBounds(200, 100, 50, 40);
		btnMul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ű���� �Է� ���� �о����
				String num1 = tfName.getText();
				String num2 = tfName1.getText();
				int mul = Integer.parseInt(num1) * Integer.parseInt(num2);

				tfNameOut.setText(mul + "");
			}
		});

		// ������ ��ư
		btnDiv = new JButton("/");
		btnDiv.setBounds(250, 100, 50, 40);
		btnDiv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ű���� �Է� ���� �о����
				double div=0.0;
				String num1 = tfName.getText();
				String num2_ = tfName1.getText();
				int num2 = Integer.parseInt(num2_);
				if(num2 != 0) {
					 div = Integer.parseInt(num1) / (double)num2;					
				}				

				tfNameOut.setText(div + "");
			}
		});

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
		new Swing4();
		// Swing3 f2 = f1;

	}

}