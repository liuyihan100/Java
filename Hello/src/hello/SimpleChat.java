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
		// TODO 自动生成的方法存根
		SimpleChat chat = new SimpleChat();
		chat.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("SimpleChat"); //创建窗口
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20,20,20,20));
		frame.add(panel);
		
		input = new JTextArea(8,20); //创建对话框
		input.setLineWrap(true); //设置自动换行
		input.setEditable(false); //设置不可编辑
		
		JScrollPane scroller = new JScrollPane(input); //创建滚动面板
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //开启竖向滚动条
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //关闭水平滚动条
		
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
			// TODO 自动生成的方法存根
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
			// TODO 自动生成的方法存根
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
