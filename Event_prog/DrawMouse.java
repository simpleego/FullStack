package com.simple.ex;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Rectangle{
	int x,y,w,h;
}

class Mypanel1 extends JPanel
      implements MouseListener {
	
	BufferedImage img = null;
	int img_x=0, img_y=0;
	Rectangle[] array = new Rectangle[100];
	
	int index=0;	
	
	public Mypanel1() {
		// 윈도우 초기화
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Rectangle r : array) {
			if( r != null) {
				g.drawRect(r.x, r.y, r.w, r.h);				
			}
		}
		System.out.println("->->->");
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// 마우스 왼쪽버튼을 누르면 발생
		if(index > 100) return;
		array[index]=new Rectangle();
		array[index].x = e.getX();
		array[index].y = e.getY();
		array[index].w = 50;
		array[index].h = 50;
		index++;
		repaint();	// 다시 그리기 호출(paintComponent)
	}

	@Override
	public void mouseReleased(MouseEvent e){
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {		
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {	
	}
}

public class DrawMouse extends JFrame {
	
	public DrawMouse() {
		// 
		setTitle("마우스 이벤트");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new Mypanel1());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DrawMouse();
	}
}
