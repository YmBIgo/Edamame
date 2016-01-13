package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TransitionPage extends JFrame{
	TransitionPage(){
		super();
	}
	void NextPage(JPanel panel){
		JPanel next = panel;
		add(next, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}
