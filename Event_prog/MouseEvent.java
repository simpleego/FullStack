package com.simple.ex;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEvent extends JFrame 
      implements MouseListener, MouseMotionListener {
	
	public MouseEvent() {
		// ������ �ʱ�ȭ
		setTitle("���콺 �̺�Ʈ");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������ ���̾ƿ� ����
		// border ���̾ƿ��� ������
		
		// ������Ʈ ����
		JPanel panel = new JPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		// ������Ʈ �����ӿ� �߰�
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseEvent();
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("���콺 Draged"+e.getClickCount(),e);
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("���콺 Moved"+e.getClickCount(),e);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("���콺 Clicked"+e.getClickCount(),e);
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// ���콺 ���ʹ�ư�� ������ �߻�
		display("���콺 ����"+e.getClickCount(),e);
		
	}



	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		display("���콺 release"+e.getClickCount(),e);
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// 
		display("���콺 Entered"+e.getClickCount(),e);
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// 
		display("���콺 Exited"+e.getClickCount(),e);
	}
	
	private void display(String str, java.awt.event.MouseEvent e) {
		// 
		System.out.println(str+"X="+e.getX()+"Y="+e.getY());	
	}

}
