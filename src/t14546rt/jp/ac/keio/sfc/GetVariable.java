package t14546rt.jp.ac.keio.sfc;

public class GetVariable extends GetSyntax {
	GetVariable(String name, String type, String[] modifier) {
		super(name);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		syntaxString = type + " " + name + ";\n";
	}
	GetVariable(String name, String type, String value, String[] modifier) {
		super(name);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		syntaxString += type + " " + name + " = " + value + ";\n";
	}

}
