package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui1B implements ActionListener{

	JButton button;
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Gui1B gui = new Gui1B();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("���");
		
		button.addActionListener(this);
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		button.setText("���");
	}

}
