package t14546rt.jp.ac.keio.sfc;

import javax.swing.JPanel;

public class GetSyntax {
	protected String name, syntaxString;
	protected JPanel panel;
	GetSyntax(String n){
		name = n;
	}
	public String get(){
		return syntaxString;
	}
	public JPanel getPanel(){
		return panel;
		
	}
}
