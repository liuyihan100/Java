package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui1C{

	JButton button;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Gui1C gui = new Gui1C();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("点击");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				button.setText("你好");
			}
		});
		
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}