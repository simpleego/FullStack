package com.simple.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IndependentEvent extends JFrame implements ActionListener {
	JButton btn, btn1;
	JTextField tfName, tfName1, tfNameOut;
	JLabel lblName, lblName1;
	private JButton btnMinus;
	private JButton btnMul;
	private JButton btnDiv;
	Divider div=null;
	
	public void setTfNameOut(String message) {
		tfNameOut.setText(message);
	}

	public IndependentEvent() {

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
		btn.addActionListener(this); 	

		// ���� ��ư
		btnMinus = new JButton("-");
		btnMinus.setBounds(150, 100, 50, 40);
		btnMinus.addActionListener(this);

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
		btnDiv.addActionListener(div);
		Divider div = new Divider(this, "0", "0");
		btnDiv.addActionListener(div);	

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
		new IndependentEvent();
		// Swing3 f2 = f1;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Ű���� �Է� ���� �о����
		String num1 = tfName.getText();
		String num2 = tfName1.getText();
		int result=0;
		
		if(e.getSource() == btn) {
			result = Integer.parseInt(num1) + Integer.parseInt(num2);
			
		}
		if(e.getSource() == btnMinus) {
			result = Integer.parseInt(num1) - Integer.parseInt(num2);			
		}
	
		tfNameOut.setText(result + "");
		
	}

}