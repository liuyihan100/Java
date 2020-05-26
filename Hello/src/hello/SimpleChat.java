//package hello;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class SimpleChat {
	
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	JTextArea input;
	JTextField output;

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SimpleChat chat = new SimpleChat();
		chat.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("SimpleChat"); //��������
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20,20,20,20));
		frame.add(panel);
		
		input = new JTextArea(8,20); //�����Ի���
		input.setLineWrap(true); //�����Զ�����
		input.setEditable(false); //���ò��ɱ༭
		
		JScrollPane scroller = new JScrollPane(input); //�����������
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //�������������
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //�ر�ˮƽ������
		
		panel.add(scroller);
		
		JPanel panelx = new JPanel();
		panelx.setBorder(new EmptyBorder(10,0,10,0));
		panel.add(panelx);
		
		output = new JTextField(20);
		JButton button = new JButton("Send");
		button.addActionListener(new ButtonListener());
		
		panelx.add(output);
		panel.add(button);
		
		setUpNet();
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.setSize(270,320);
		frame.setVisible(true);
	}
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			try {
				writer.println(output);
				writer.flush();
			}catch(Exception ex) {}
			output.setText("");
			output.requestFocus();
		}
		
	}
	
	public void setUpNet() {
		try{
			sock = new Socket("127,0,0,1",5000);
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("Networking established.");
		}catch(IOException ex) {}
	}
	
	public class IncomingReader implements Runnable{

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			String message;
			try {
				while(true) {
					if((message = reader.readLine())!=null) {
						input.append(message);
					}
				}
			}catch(Exception ex) {}
		}
		
	}
	
}
