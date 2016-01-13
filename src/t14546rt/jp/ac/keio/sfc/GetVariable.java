package t14546rt.jp.ac.keio.sfc;

public class GetVariable extends GetSyntax {
	GetVariable(String n, String type) {
		super(n);
		syntaxString = type + " " + name + ";\n";
	}
	GetVariable(String n, String type, String value) {
		super(n);
		syntaxString = type + " " + name + " = " + value + ";\n";
	}

}
