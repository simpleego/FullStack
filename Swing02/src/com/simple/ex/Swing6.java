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

		// 윈도우 초기 설정
		this.setTitle("윈도우01");
		setSize(400, 500);// 가로 세로 크기
		// 윈도우 배치 설정
		setLayout(null);
		// 컴포넌트 배치를 직접 설정(위치,크기)

		// 원하는 컴포넌트 생성
		// 키보드 입력 컴포넌트 JTextField
		lblName = new JLabel("숫자1 : ");
		lblName.setBounds(50, 5, 100, 40);

		lblName1 = new JLabel("숫자2 : ");
		lblName1.setBounds(50, 50, 100, 40);

		tfName = new JTextField();
		tfName.setBounds(100, 5, 100, 40);

		tfName1 = new JTextField();
		tfName1.setBounds(100, 50, 100, 40);

		tfNameOut = new JTextField();
		tfNameOut.setBounds(100, 150, 100, 40);

		// 버튼 생성
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

		// 뺄셈 버튼
		btnMinus = new JButton("-");
		btnMinus.setBounds(150, 100, 50, 40);
		btnMinus.addActionListener(this);

		// 곱셈 버튼
		btnMul = new JButton("x");
		btnMul.setBounds(200, 100, 50, 40);
		btnMul.addActionListener(new Multiply());

		// 나눗셈 버튼
		btnDiv = new JButton("/");
		btnDiv.setBounds(250, 100, 50, 40);
		btnDiv.addActionListener(new Divide(this));

		// 프레임에 컴포넌트 등록
		add(btn);
		add(btnMinus);
		add(btnMul);
		add(btnDiv);
		add(tfName);
		add(tfName1);
		add(tfNameOut);
		add(lblName);
		add(lblName1);

		// 윈도우 활성화(윈도우 보이게)
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		Swing6 win = new Swing6();
		// Swing3 f2 = f1;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 키보드 입력 값을 읽어오기
		String num1 = tfName.getText();
		String num2 = tfName1.getText();
		int result=0;
		if(e.getSource() == btnMinus) {
			result = Integer.parseInt(num1) - Integer.parseInt(num2);			
		}	
		tfNameOut.setText(result + "");		
	}
	
	public void sqrt() {
		System.out.println("제곱근 계산");
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
