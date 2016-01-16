package t14546rt.jp.ac.keio.sfc;

public class GetVariable extends GetSyntax {
	GetVariable(String n, String type, String[] modifier) {
		super(n);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		syntaxString = type + " " + name + ";\n";
	}
	GetVariable(String n, String type, String value, String[] modifier) {
		super(n);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		syntaxString = type + " " + name + " = " + value + ";\n";
	}

}
