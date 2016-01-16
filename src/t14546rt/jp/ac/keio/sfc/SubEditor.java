package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SubEditor extends TransitionPage implements ActionListener {
	private JTextArea text;
	private JPanel topPage;
	private JPanel controlPage;
	private String[] topPageStrings = {"クラス", "インターフェース","変数", "制御構文"};
	private String[] controlPageStrings = {"for", "if", "while","戻る"};
	
	int posx,posy,width,height;
	SubEditor(int x,int y,int w,int h, JTextArea t){
		text = t;
		topPage = makeMenuPanel(topPageStrings);
		controlPage = makeMenuPanel(controlPageStrings);
		posx = x;posy = y;width = w;height = h;
	}
	private JPanel makeMenuPanel(String[] arr){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		JButton[] jbuttons = new JButton[arr.length];

		for(int i=0; i< jbuttons.length; i++){
			jbuttons[i] = new JButton(arr[i]);
			jbuttons[i].setActionCommand(arr[i]);
			jbuttons[i].setMaximumSize(new Dimension(Short.MAX_VALUE,100));
			jbuttons[i].addActionListener(this);
			panel.add(jbuttons[i]);
		}
		return panel;
	}
	public void open(){
		nextPage(topPage,posx,posy,width,height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "クラス":
			remove(topPage);
			ClassPanel cp = new ClassPanel(10,10,500,500, text);
			setVisible(false);
			cp.open();
			break;
		case "インターフェース":
			remove(topPage);
			InterfacePanel ip = new InterfacePanel(10,10,500,500, text);
			setVisible(false);
			ip.open();
			break;
		case "変数":
			remove(topPage);
			VariablePanel vp = new VariablePanel(10,10,500,500,text);
			setVisible(false);
			vp.open();
			break;
		case "制御構文":
			remove(topPage);
			nextPage(controlPage,posx,posy,width,height);
			break;
		case "for":
			break;
		case "if":
			break;
		case "while":
			break;
		case "戻る":
			remove(controlPage);
			nextPage(topPage,posx,posy,width,height);
			break;
		}
	}
	
}
