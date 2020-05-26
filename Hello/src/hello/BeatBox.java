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
		// TODO �Զ����ɵķ������
		BeatBox music = new BeatBox();
		music.build();
	}
	
	public void build() {
		JFrame mainFrame = new JFrame("BeatBox"); //��������
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel background = new JPanel(new BorderLayout()); //�������
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		Box nameBox = new Box(BoxLayout.Y_AXIS); //����������
		
		for(int i = 0;i < instrumentNames.length;i++) {
			JLabel label = new JLabel(instrumentNames[i]);
			label.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
			nameBox.add(label); //���������ǩ
		}
		
		background.add(nameBox,BorderLayout.WEST); //���������������
		
		Box buttonBox = new Box(BoxLayout.Y_AXIS); //������ť��
		buttonBox.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
		
		JButton startBut = new JButton("Start"); //������ť
		startBut.addActionListener(new MyStartListener()); //����¼�
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
		
		background.add(buttonBox,BorderLayout.EAST); //��Ӱ�ť��������
		
		GridLayout grid = new GridLayout(16,16); //����16*16GridLayout����
		grid.setVgap(1); //���ô�ֱ���
		grid.setHgap(2); //����ˮƽ���
		JPanel checkPanel = new JPanel(grid); //������ѡ��
		
		for(int i = 0;i < instrumentNames.length * 16;i++) {
			JCheckBox checkBox = new JCheckBox();
			nameChecks.add(checkBox); //�����ѡ��ť
			checkPanel.add(checkBox); //��Ӷ�ѡ��ť
		}
		
		background.add(checkPanel); //��Ӷ�ѡ��������
		
		setUp(); //���ö�ý��
		
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
			// TODO �Զ����ɵķ������
			sequencer.stop();
		}
	}
	
	public class MyUpTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			float factor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(factor * 1.03));
		}
		
	}
	
	public class MyDownTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			float factor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(factor * 0.97));
		}
		
	}
	
	public void startFunc() {
		int[] trackList = new int[16];
		
		seq.deleteTrack(track);
		track = seq.createTrack();
		
		for(int i = 0;i < instruments.length;i++) { //����ѭ��
			int key = instruments[i];
			for(int j = 0;j < 16;j++) { //����ѭ��
				JCheckBox check = nameChecks.get(j + i * 16);
				if(check.isSelected()) { //�ж϶�ѡ��ť�Ƿ�ѡ��
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
