package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TransitionPage extends JFrame{
	TransitionPage(){
		super();
	}
	void nextPage(JPanel panel, int x,int y,int w,int h){
		add(panel, BorderLayout.CENTER);
		pack();
		setBounds(x,y,w,h);
		setVisible(true);
	}
}
