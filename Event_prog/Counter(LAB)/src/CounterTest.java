import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

// �ҽ��� �Է��ϰ� Ctrl+Shift+O�� ������ �ʿ��� ������ �����Ѵ�. 

class MyCounter extends JFrame  {
	JLabel label, label1, label2;
	JButton button;
	int count = 0;
	//private Timer timer;
	

	public MyCounter() {
		JPanel panel = new JPanel();
		label = new JLabel("Counter");
		panel.add(label);

		label1 = new JLabel("" + count);
		label1.setFont(new Font("Serif", 	// ���̺� ��Ʈ�� �����Ѵ�. 
			Font.BOLD | Font.ITALIC, 100)); 

		
		
		label2 = new JLabel("" + count);
		label2.setFont(new Font("Serif", 	// ���̺� ��Ʈ�� �����Ѵ�. 
			Font.BOLD | Font.ITALIC, 100)); 

		panel.add(label2);
		panel.add(label1);

		button = new JButton("ī���� ����");
		panel.add(button);
		//button.addActionListener(this);

		add(panel);
		setSize(300, 200);
		setTitle("My Counter");

		setVisible(true);
		
		class action implements ActionListener{
	        
	        public void actionPerformed(ActionEvent e) {            
	            
	        	if(count++ <= 8) {
	    			//count++;
	    			label1.setText(count + "");
	    		}
	        } 
		}
		
		Timer t = new Timer(1000, new action());
	    t.start();
	}
}
	

/*
 * class Myclass implements ActionListener { MyCounter myCounter;
 * 
 * public Myclass() { // TODO Auto-generated constructor stub } public
 * Myclass(MyCounter myCounter) { this.myCounter = myCounter; }
 * 
 * 
 * @Override public void actionPerformed(ActionEvent e) { if(myCounter.count++
 * <= 8) { //count++; myCounter.label1.setText(myCounter.count + ""); }
 * 
 * }
 * 
 * }
 */

public class CounterTest {
	public static void main(String[] args) {
		MyCounter obj = new MyCounter();
		/*
		 * ActionListener listner = new Myclass(obj); Timer timer = new Timer(1000,
		 * listner); timer.start();
		 */
		
		
	}
}