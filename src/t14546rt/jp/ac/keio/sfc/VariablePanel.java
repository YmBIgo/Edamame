package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VariablePanel extends Panel implements ActionListener{
	private JTextField name,type,value;
	private JCheckBox[] modi = new JCheckBox[12];
	private JButton submit;
	private String[] labelstr = {"変数", "変数名：", "型:", "値:", "修飾子:"};
	private JLabel[] labels;
	
	VariablePanel(int x, int y, int w, int h, JTextArea t) {
		super(x, y, w, h, t);
		name = new JTextField();
		type = new JTextField();
		value = new JTextField();
		for(int i=0;i<modi.length;i++){
			modi[i] = new JCheckBox(mstr[i]);
		}
		submit = new JButton("決定");
		labels = new JLabel[labelstr.length]; //各ラベル
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
		setConfig(config,0,4,1,1);
		layout.setConstraints(labels[4], config);
		
		setConfig(config,1,1,4,1);
		layout.setConstraints(name, config);
		name.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,1,2,4,1);
		layout.setConstraints(type, config);
		type.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,1,3,4,1);
		layout.setConstraints(value, config);
		value.setPreferredSize(new Dimension(200,30));
		
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				setConfig(config,j+1,i+4,1,1);
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
		result.add(labels[3]);
		result.add(labels[4]);
		result.add(name);
		result.add(type);
		result.add(value);
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
		GetVariable gv;
		if(value.getText().equals("")){
			gv = new GetVariable(name.getText(), type.getText(), mstr);
		}else{
			gv = new GetVariable(name.getText(), type.getText(), value.getText(), mstr);
		}
		return gv.get();
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
