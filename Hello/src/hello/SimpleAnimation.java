package hello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
	
	int x = 70;
	int y = 70;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.add(drawPanel);
		
		
		frame.setSize(300,300);
		frame.setVisible(true);
		
		int speedx = 1;
		int speedy = 1;
		
		while(true) {
			
			if(x > drawPanel.getWidth() - 40) {
				x = drawPanel.getWidth() - 40;
				speedx = -speedx;
			}
			else if(x < 0) {
				x = 0;
				speedx = -speedx;
			}
			
			if(y > drawPanel.getHeight() - 40) {
				y = drawPanel.getHeight()  - 40;
				speedy = -speedy;
			}
			else if(y < 0) {
				y = 0;
				speedy = -speedy;
			}
			
			x += speedx;
			y += speedy;
			
			drawPanel.repaint();
			
			try {
				Thread.sleep(5);
			}catch(Exception ex) {}
		}
	}
	
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}
}
