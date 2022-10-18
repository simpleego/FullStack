package com.simple.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainWindow extends JFrame implements ActionListener {

	JTextField tfID1, tfID2, tfName, tfResult;
	JLabel lblID, lbl_, lblName, lblResult;
	JButton btnAge, btnGender, btnAdult, btnArea;
	JPanel panelInfo, panelResult, panelButton;
	InfoPanel infoPanel;
	ResultPanel resultPanel;	

	public MainWindow() {
		// 프레임 설정 초기화
		setTitle("주민번호처리");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(1,30,30));

		// 컴포넌트 생성
		Color gray = new Color(200, 200, 200);
		Font  font = new Font("굴림체", Font.BOLD, 24);
		// 패널에 패딩값 설정 		
		 
		// 컴포넌트 등록
		//add(new InfoPanel(gray, font), BorderLayout.NORTH);
		infoPanel = new InfoPanel(gray, font);
		resultPanel = new ResultPanel(gray, font);
		add(infoPanel);
		add(resultPanel);
		add(new ButtonPanel(infoPanel, resultPanel, gray, font));
//		add(panelResult);
//		add(panelButton);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
