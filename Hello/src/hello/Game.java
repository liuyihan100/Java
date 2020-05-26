package hello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game{
	
	JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Game game = new Game();
		game.play();
	}
	
	public void play() {
		MyDrawPanel my = new MyDrawPanel();
		frame.add(my);
		JButton button = new JButton("�ı���ɫ");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				frame.repaint();
			}
		});
		frame.add(button,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	
	public class MyDrawPanel extends JPanel{
		
		public void paintComponent(Graphics g) {	
			/*
			 * �����Ƭ
			Image img = new ImageIcon("C:\\Users\\˧˧С��\\Desktop\\��\\77208121_p0_master1200.jpg").getImage();
			g.drawImage(img, 3, 4, this);
			*/
			
			/*
			 * ���ɫ��Բ
			 */
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			int red = (int)(Math.random() * 255);
			int green = (int)(Math.random() * 255);
			int blue = (int)(Math.random() * 255);
			
			Color color = new Color(red,green,blue);
			
			g.setColor(color);
			g.fillOval(70, 70, 100, 100);
			
			
			/*
			 * ����ɫ��Բ
			Graphics2D gg = (Graphics2D)g;
			
			GradientPaint paint = new GradientPaint(70,  70, Color.blue, 150, 150, Color.GREEN);
			
			gg.setPaint(paint);
			gg.fillOval(70, 70, 100, 100);
			*/
		}
	}

}
