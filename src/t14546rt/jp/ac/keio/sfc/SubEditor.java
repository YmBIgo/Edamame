package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubEditor extends TransitionPage {
	SubEditor(String[] arr){
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		int arr_count = arr.length;
		JButton[] jbuttons = new JButton[arr_count];

		for(int i=0; i< arr_count; i++){
			jbuttons[i] = new JButton(arr[i]);
			jbuttons[i].setMaximumSize(new Dimension(Short.MAX_VALUE,100));
			p.add(jbuttons[i]);
		}
		getContentPane().add(p, BorderLayout.CENTER);
	}
}
