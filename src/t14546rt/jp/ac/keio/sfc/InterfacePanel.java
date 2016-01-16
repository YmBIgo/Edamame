package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfacePanel extends Panel implements ActionListener{
	private JTextField name;
	private JCheckBox[] modi;
	private JButton submit;
	private String[] labelstr = {"Interface", "インターフェース名：", "修飾子:"};
	private JLabel[] labels;
	private HashMap<String, Boolean> modifier = new HashMap<String,Boolean>();

	InterfacePanel(int x, int y, int w, int h, JTextArea t) {
		super(x, y, w, h, t);
		name = new JTextField(); //クラス名
		modi = new JCheckBox[mstr.length]; //修飾子
		for(int i=0;i<mstr.length;i++){
			modi[i] = new JCheckBox(mstr[i]);
		}
		submit = new JButton("決定");
		labels = new JLabel[labelstr.length]; //各ラベル
		for(int i=0;i<labels.length;i++){
			labels[i] = new JLabel(labelstr[i]);
		}
		for(int i=0;i<mstr.length;i++){
			modifier.put(mstr[i], false);
		}
		makePanel();
	}
	public void makePanel(){
		JPanel result = new JPanel();
		result.setLayout(layout);
		
		setConfig(config,0,0,4,1);
		layout.setConstraints(labels[0], config);
		setConfig(config,0,1,1,1);
		layout.setConstraints(labels[1], config);
		setConfig(config,0,2,1,1);
		layout.setConstraints(labels[2], config);
		
		setConfig(config,1,1,4,1);
		layout.setConstraints(name, config);
		name.setPreferredSize(new Dimension(200,30));
		
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				setConfig(config,j+1,i+2,1,1);
				layout.setConstraints(modi[j+i*4], config);
			}
		}
		
		setConfig(config,4,0,1,1);
		layout.setConstraints(submit, config);
		submit.setActionCommand("submit");
		submit.addActionListener(this);
		
		result.add(labels[0]);
		result.add(labels[1]);
		result.add(labels[2]);
		result.add(name);
		result.add(submit);
		for(int i=0;i<modi.length;i++){
			result.add(modi[i]);
		}
		
		panel = result;
	}
	
	private String getData(){
		ArrayList<String> ms = new ArrayList<String>();
		for(int i=0;i<modi.length;i++){
			if(modi[i].isSelected()){
				ms.add(modi[i].getText());
			}
		}
		String[] mstr = new String[ms.size()];
		for(int i=0;i<mstr.length;i++){
			mstr[i] = ms.get(i);
		}
		
		GetInterface gi = new GetInterface(name.getText(), mstr);
		return gi.get();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "submit":
			if(!(name.getText().equals(""))){
				setVisible(false);
				System.out.println(getData());
				InsertText it = new InsertText(getData(),text);
				it.caret_insert();
			}
			break;
			
		}
	}

}
