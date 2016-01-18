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

public class ForPanel extends Panel implements ActionListener{
	private JTextField ini,con,upd;
	private JButton submit;
	private String[] labelstr = {"for","初期化処理", "継続条件", "カウンタ更新処理"};
	private JLabel[] labels;
	ForPanel(int x, int y, int w, int h, JTextArea t) {
		super(x, y, w, h, t);
		ini = new JTextField();
		con = new JTextField();
		upd = new JTextField();
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
		
		setConfig(config,1,1,4,1);
		layout.setConstraints(ini, config);
		ini.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,1,2,4,1);
		layout.setConstraints(con, config);
		con.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,1,3,4,1);
		layout.setConstraints(upd, config);
		upd.setPreferredSize(new Dimension(200,30));
		
		setConfig(config,4,0,1,1);
		layout.setConstraints(submit, config);
		submit.setActionCommand("submit");
		submit.addActionListener(this);
		
		result.add(labels[0]);
		result.add(labels[1]);
		result.add(labels[2]);
		result.add(labels[3]);
		result.add(ini);
		result.add(con);
		result.add(upd);
		result.add(submit);
		
		panel = result;
	}
	
	private String getData(){
		GetFor gf = new GetFor(ini.getText(),con.getText(),upd.getText());
		return gf.get();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "submit":
			if(!( ini.getText().equals("") ) && !( con.getText().equals("") ) && !( upd.getText().equals("") ) ){
				setVisible(false);
				InsertText it = new InsertText(getData(),text);
				it.caret_insert();
			}else{
				System.out.println("failed");
			}
			break;
			
		}
	}

}
