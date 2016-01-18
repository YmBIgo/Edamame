package t14546rt.jp.ac.keio.sfc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IfPanel extends Panel implements ActionListener{
	private JTextField value1,value2;
	private JButton submit;
	private JRadioButton[] rela;
	private ButtonGroup bg;
	private String[] labelstr = {"if", "値:", "値２:", "関係演算子:"};
	private JLabel[] labels;
	IfPanel(int x, int y, int w, int h, JTextArea t) {
		super(x, y, w, h, t);
		value1 = new JTextField();
		value2 = new JTextField();
		submit = new JButton("決定");
		labels = new JLabel[labelstr.length]; //各ラベル
		rela = new JRadioButton[6];
		rela[0] = new JRadioButton("==");
		rela[1] = new JRadioButton("!=");
		rela[2] = new JRadioButton("<=");
		rela[3] = new JRadioButton(">=");
		rela[4] = new JRadioButton("<");
		rela[5] = new JRadioButton(">");
		bg = new ButtonGroup();
		for(int i=0;i<6;i++){
			bg.add(rela[i]);
		}
		for(int i=0;i<labels.length;i++){
			labels[i] = new JLabel(labelstr[i]);
		}
		makePanel();
	}
	private void makePanel(){
		JPanel result = new JPanel();
		result.setLayout(layout);
		
		setConfig(config,0,0,4,1);
		layout.setConstraints(labels[0], config);
		setConfig(config,0,1,1,1);
		layout.setConstraints(labels[1], config);
		setConfig(config,0,2,1,1);
		layout.setConstraints(labels[2], config);
		setConfig(config,0,3,1,1);
		layout.setConstraints(labels[3], config);
		
		setConfig(config,1,1,4,1);
		layout.setConstraints(value1, config);
		value1.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,1,2,4,1);
		layout.setConstraints(value2, config);
		value2.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,4,0,1,1);
		layout.setConstraints(submit, config);
		submit.setActionCommand("submit");
		submit.addActionListener(this);
		
		result.add(labels[0]);
		result.add(labels[1]);
//		result.add(labels[2]);
//		result.add(labels[3]);
		result.add(value1);
//		result.add(value2);
//		for(int i=0;i<rela.length;i++){
//			result.add(rela[i]);
//		}
		result.add(submit);
		
		panel = result;
	}
	
	private String getData(){
		GetIf gi = new GetIf(value1.getText());
		return gi.get();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "submit":
			setVisible(false);
			InsertText it = new InsertText(getData(),text);
			it.caret_insert();
			break;
		}
	}
}
