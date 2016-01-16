package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JFrame {
	protected JPanel panel;
	protected String[] mstr = {"public","protected","private","static","final","abstract","native","synchronized","transient","volatile","strictfp","const"};
	protected GridBagLayout layout;
	protected GridBagConstraints config;
	protected int posx,posy,width,height;
	Panel(int x,int y,int w,int h){
		panel = new JPanel();
		layout = new GridBagLayout();
		config = new GridBagConstraints();
		posx = x;posy = y;width = w;height = h;
	}
	public void open(){
		add(panel, BorderLayout.CENTER);
		pack();
		setBounds(posx,posy,width,height);
		setVisible(true);
	}
	public void setConfig(GridBagConstraints gbc, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
	}
}
