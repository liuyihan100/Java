package hello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class BeatBox {
	
	String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
			"Crash Cymbal","Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Long Conga",
			"Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"
	};
	
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	ArrayList<JCheckBox> nameChecks = new ArrayList<JCheckBox>();
	
	Sequencer sequencer;
	Sequence seq;
	Track track;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BeatBox music = new BeatBox();
		music.build();
	}
	
	public void build() {
		JFrame mainFrame = new JFrame("BeatBox"); //创建窗口
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel background = new JPanel(new BorderLayout()); //创建面板
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		Box nameBox = new Box(BoxLayout.Y_AXIS); //创建乐器块
		
		for(int i = 0;i < instrumentNames.length;i++) {
			JLabel label = new JLabel(instrumentNames[i]);
			label.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
			nameBox.add(label); //添加乐器标签
		}
		
		background.add(nameBox,BorderLayout.WEST); //添加乐器块至背景
		
		Box buttonBox = new Box(BoxLayout.Y_AXIS); //创建按钮块
		buttonBox.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
		
		JButton startBut = new JButton("Start"); //创建按钮
		startBut.addActionListener(new MyStartListener()); //添加事件
		buttonBox.add(startBut);
		
		JButton stopBut = new JButton("Stop");
		stopBut.addActionListener(new MyStopListener());
		buttonBox.add(stopBut);
		
		JButton upBut = new JButton("Tempo Up");
		upBut.addActionListener(new MyUpTempoListener());
		buttonBox.add(upBut);
		
		JButton downBut = new JButton("Tempo down");
		downBut.addActionListener(new MyDownTempoListener());
		buttonBox.add(downBut);
		
		background.add(buttonBox,BorderLayout.EAST); //添加按钮块至背景
		
		GridLayout grid = new GridLayout(16,16); //创建16*16GridLayout对象
		grid.setVgap(1); //设置垂直间距
		grid.setHgap(2); //设置水平间距
		JPanel checkPanel = new JPanel(grid); //创建多选块
		
		for(int i = 0;i < instrumentNames.length * 16;i++) {
			JCheckBox checkBox = new JCheckBox();
			nameChecks.add(checkBox); //保存多选按钮
			checkPanel.add(checkBox); //添加多选按钮
		}
		
		background.add(checkPanel); //添加多选块至背景
		
		setUp(); //设置多媒体
		
		mainFrame.add(background);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public void setUp() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			seq = new Sequence(Sequence.PPQ, 4);
			track = seq.createTrack();
			sequencer.setTempoInBPM(120);
		}catch(Exception ex) {}
	}
	
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			startFunc();
		}
	}
	
	public class MyStopListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			sequencer.stop();
		}
	}
	
	public class MyUpTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			float factor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(factor * 1.03));
		}
		
	}
	
	public class MyDownTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			float factor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(factor * 0.97));
		}
		
	}
	
	public void startFunc() {
		int[] trackList = new int[16];
		
		seq.deleteTrack(track);
		track = seq.createTrack();
		
		for(int i = 0;i < instruments.length;i++) { //乐器循环
			int key = instruments[i];
			for(int j = 0;j < 16;j++) { //节拍循环
				JCheckBox check = nameChecks.get(j + i * 16);
				if(check.isSelected()) { //判断多选按钮是否被选中
					trackList[j] = key;
				}
				else {
					trackList[j] = 0;
				}
			}
			makeTracks(trackList);
			track.add(makeEvent(176, 1, 127, 0, 16));
		}
		track.add(makeEvent(192, 9, 1, 0, 15));
		
		try {
			sequencer.setSequence(seq);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception ex) {}
	}
	
	public void makeTracks(int[] list) {
		for(int i = 0;i < list.length;i++) {
			int key = list[i];
			if(key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100,i + 1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage msg = new ShortMessage();
			msg.setMessage(comd, chan, one, two);
			event = new MidiEvent(msg, tick);
		}catch(Exception ex) {}
		return event;
	}
}
