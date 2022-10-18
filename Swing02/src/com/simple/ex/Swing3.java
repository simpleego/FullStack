package com.simple.ex;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing3 extends JFrame {
	JButton btn, btn1;

	public Swing3() {
		
		// 윈도우 초기 설정
		setTitle("윈도우01");
		setSize(400, 500);// 가로 세로 크기
		// 윈도우 배치 설정
		setLayout(null);
		// 컴포넌트 배치를 직접 설정(위치,크기)

		// 원하는 컴포넌트 생성
		// 버튼 생성
		btn = new JButton("눌러봐");
		btn.setBounds(100, 100, 100, 40);

		btn1 = new JButton("눌러봐");
		btn1.setBounds(210, 100, 100, 40);

		// 프레임에 컴포넌트 등록
		add(btn);
		add(btn1);

		// 윈도우 활성화(윈도우 보이게)
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Swing3();
		//Swing3 f2 = f1;

	}

}
