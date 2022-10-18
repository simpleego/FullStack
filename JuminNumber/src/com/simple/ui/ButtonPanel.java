package com.simple.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ButtonPanel extends JPanel implements ActionListener {

	JButton btnAge, btnGender, btnAdult, btnArea;

	Color gray = null;
	Font font = null;
	InfoPanel infoPanel;
	ResultPanel resultPanel;

	public ButtonPanel(InfoPanel infoPanel, ResultPanel resultPanel, Color gray, Font font) {

		this.gray = gray;
		this.font = font;
		this.infoPanel = infoPanel;
		this.resultPanel = resultPanel;

		// 상하좌우 10씩 띄우기
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		this.setLayout(new GridLayout(0, 4, 10, 20));
		this.setBackground(gray);
		this.setPreferredSize(new Dimension(660, 80));

		btnAge = new JButton("나 이 ");
		btnAge.setFont(font);
		btnAge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int age = getAge();				
				resultPanel.tfResult.setText(age + "");
			}
		});

		btnGender = new JButton("성 별 ");
		btnGender.setFont(font);
		btnGender.addActionListener(this);

		btnAdult = new JButton("성인여부 ");
		btnAdult.setFont(font);
		btnAdult.addActionListener(new AdultCheck());

		btnArea = new JButton("지 역 ");
		btnArea.setFont(font);
		btnArea.addActionListener(new BirthRegion(infoPanel, resultPanel));

		add(btnAge);
		add(btnGender);
		add(btnAdult);
		add(btnArea);

	}
	
	// 나이 구하기
	private int getAge() {
		// 달력 객체를 얻고, 당해년도를 구하기
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);

		int birthYear = 0;
		int age = 0;

		String id1 = infoPanel.tfID1.getText();
		String id2 = infoPanel.tfID2.getText();
		int age_ = Integer.parseInt(id1.substring(0, 2));

		char gender = id2.charAt(0);
		switch (gender) {
		case '1':
		case '2':
			birthYear = 1900 + age_;
			break;
		case '3':
		case '4':
			birthYear = 2000 + age_;
			break;
		}
		
		return year - birthYear;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 성별 구하기
		String gender = "남자";

		String id2 = infoPanel.tfID2.getText();
		char gender_ = id2.charAt(0);

		switch (gender_) {
		case '2':
		case '4':
			gender = "여자";
			break;
		}

		resultPanel.tfResult.setText(gender);
	}
	
	private class AdultCheck implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// 성별 구하기
			String adult = "성년";

			int age = getAge();

			if(age < 20) {
				adult = "미성년";
			}

			resultPanel.tfResult.setText(adult);
			
		}
		
	}
}
