package com.simple.ex;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing02 {
	
	public static void main(String[] args) {
		
		JButton btn, btn1;

		JFrame win = new JFrame();
		
		// 윈도우 초기 설정
		win.setTitle("윈도우01");
		win.setSize(400,500);// 가로 세로 크기
		// 윈도우 배치 설정
		win.setLayout(null);
		// 컴포넌트 배치를 직접 설정(위치,크기)
		
		// 원하는 컴포넌트 생성
		// 버튼 생성
		btn = new JButton("눌러봐");
		btn.setBounds(100, 100, 100, 40);
		
		btn1 = new JButton("눌러봐");
		btn1.setBounds(210, 100, 100, 40);
		
		// 프레임에 컴포넌트 등록
		win.add(btn);
		win.add(btn1);		
		
		// 윈도우 활성화(윈도우 보이게)
		win.setResizable(false);
		win.setVisible(true);
		
	}

}
