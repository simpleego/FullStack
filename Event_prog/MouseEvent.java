package com.simple.ex;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEvent extends JFrame 
      implements MouseListener, MouseMotionListener {
	
	public MouseEvent() {
		// 윈도우 초기화
		setTitle("마우스 이벤트");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우 레이아웃 설정
		// border 레이아웃이 설정됨
		
		// 컴포넌트 생성
		JPanel panel = new JPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		// 컴포넌트 프레임에 추가
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseEvent();
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("마우스 Draged"+e.getClickCount(),e);
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("마우스 Moved"+e.getClickCount(),e);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("마우스 Clicked"+e.getClickCount(),e);
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// 마우스 왼쪽버튼을 누르면 발생
		display("마우스 누름"+e.getClickCount(),e);
		
	}



	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("마우스 release"+e.getClickCount(),e);
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// 
		display("마우스 Entered"+e.getClickCount(),e);
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// 
		display("마우스 Exited"+e.getClickCount(),e);
	}
	
	private void display(String str, java.awt.event.MouseEvent e) {
		// 
		System.out.println(str+"X="+e.getX()+"Y="+e.getY());	
	}

}
