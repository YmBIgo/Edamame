package t14546rt.jp.ac.keio.sfc;
import javax.swing.JTextArea;

public class InsertText{
	
	private String text;
	JTextArea area;
	int position;//
	
	InsertText(String t, JTextArea a){
		text = t;
		area = a;
		position = a.getCaretPosition();//
	}
	public void caret_insert(){
		area.insert(text,position);//
	}
}
