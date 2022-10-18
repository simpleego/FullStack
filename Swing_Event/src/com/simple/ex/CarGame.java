package com.simple.ex;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Mypanel extends JPanel {
	BufferedImage img = null;
	int img_x = 100;
	int img_y = 100;
	
	public Mypanel() {
		try {
			img = ImageIO.read(new File("car.gif"));
		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:
					if(img_y >= 10) {
						img_y -= 10;						
					}else {
						img_y += 10;
					}
					break;
				case KeyEvent.VK_DOWN:
					if(img_y < 220) {
						img_y += 10;						
					}else {
						img_y = 220;
					}					
					break;
				case KeyEvent.VK_LEFT:
					if(img_x > 0) {
						img_x -= 10;						
					}else {
						img_x = 0;
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(img_x < 225) {
						img_x += 10;						
					}else {
						img_x = 225;
					}
					break;
				case KeyEvent.VK_SPACE:
					if(img_x < 225) {
						img_x += 10;						
					}else {
						img_x = 225;
					}
					
					if(img_y >=10) {
						img_y -= 10;
					}else {
						img_y += 10;
					}
					break;
					
				}
				// 이동한 좌표에서 자동차 다시 그리기
				System.out.println("x :"+img_x);
				System.out.println("y :"+img_y);
				repaint();				
			}
			
		});
		// 패널에서 키보드 이벤트가 적용되도록 설정
		this.requestFocus();
		setFocusable(true);		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}
}

public class CarGame extends JFrame {
	
	public CarGame() {
		// 윈도우 초기화
		setTitle("자동차 게임");
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컴포넌트 생성 등록
		add(new Mypanel(), BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new CarGame();
	}
}
