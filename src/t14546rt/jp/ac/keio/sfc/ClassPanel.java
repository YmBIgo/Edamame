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

public class ClassPanel extends Panel implements ActionListener{
	private JTextArea text;
	private JTextField name,ext;
	private JCheckBox[] modi;
	private ArrayList<JTextField> ints;
	private JButton add,submit;
	private String[] labelstr = {"Class", "クラス名：", "修飾子:", "継承:", "インターフェース:"};
	private JLabel[] labels;
	private int intsnum;
	private HashMap<String, Boolean> modifier = new HashMap<String,Boolean>();
	ClassPanel(int x,int y,int w,int h, JTextArea t){
		super(x,y,w,h);
		text = t;
		name = new JTextField(); //クラス名
		ext = new JTextField(); //継承するクラス名
		modi = new JCheckBox[mstr.length]; //修飾子
		for(int i=0;i<mstr.length;i++){
			modi[i] = new JCheckBox(mstr[i]);
		}
		ints = new ArrayList<JTextField>(); //インターフェース用のテキストエリア
		ints.add(new JTextField());
		add = new JButton("追加");
		submit = new JButton("決定");
		labels = new JLabel[labelstr.length]; //各ラベル
		for(int i=0;i<labels.length;i++){
			labels[i] = new JLabel(labelstr[i]);
		}
		intsnum = 1;
		for(int i=0;i<mstr.length;i++){
			modifier.put(mstr[i], false);
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
		setConfig(config,0,5,1,1);
		layout.setConstraints(labels[3], config);
		setConfig(config,0,6,1,1);
		layout.setConstraints(labels[4], config);
		
		setConfig(config,1,1,4,1);
		layout.setConstraints(name, config);
		name.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,1,5,4,1);
		layout.setConstraints(ext, config);
		ext.setPreferredSize(new Dimension(200,30));
		
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				setConfig(config,j+1,i+2,1,1);
				layout.setConstraints(modi[j+i*4], config);
			}
		}
		
		setConfig(config,0,7,1,1);
		layout.setConstraints(add, config);
		add.setActionCommand("add");
		add.addActionListener(this);
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
		result.add(ext);
		result.add(add);
		result.add(submit);
		
		for(int i=0;i<modi.length;i++){
			result.add(modi[i]);
		}
		for(int i=0;i<ints.size();i++){
			setConfig(config,1,6,4,1);
			layout.setConstraints(ints.get(i), config);
			ints.get(i).setPreferredSize(new Dimension(200,30));
			result.add(ints.get(i));
		}
		
		panel = result;
	}
	
	private String getData(){
		ArrayList<String> ms = new ArrayList<String>();
		ArrayList<String> is = new ArrayList<String>();
		for(int i=0;i<modi.length;i++){
			if(modi[i].isSelected()){
				ms.add(modi[i].getText());
			}
		}
		String[] mstr = new String[ms.size()];
		for(int i=0;i<mstr.length;i++){
			mstr[i] = ms.get(i);
		}
		
		for(int i=0;i<ints.size();i++){
			if(!(ints.get(i).getText().equals(""))){
				is.add(ints.get(i).getText());
			}
		}
		String[] istr = new String[is.size()];
		for(int i=0;i<istr.length;i++){
			istr[i] = is.get(i);
		}
		
		GetClass gc = new GetClass(name.getText(), mstr,ext.getText(),istr);
		return gc.get();
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "add":
			remove(panel);
			intsnum++;
			ints.add(new JTextField());
			for(int i=0;i<ints.size();i++){
				panel.remove(ints.get(i));
				setConfig(config,1,6+i,4,1);
				layout.setConstraints(ints.get(i), config);
				ints.get(i).setPreferredSize(new Dimension(200,30));
				panel.add(ints.get(i));
			}
			add(panel, BorderLayout.CENTER);
			pack();
			setBounds(posx,posy,width,height);
			setVisible(true);
			break;
		case "submit":
			if(name.getText().equals("")){
				
			}else{
				setVisible(false);
				System.out.println(getData());
				InsertText it = new InsertText(getData(),text);
				it.caret_insert();
			}
			break;
			
		}
	}
}
