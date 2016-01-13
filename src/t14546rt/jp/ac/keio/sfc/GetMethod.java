package t14546rt.jp.ac.keio.sfc;

public class GetMethod extends GetSyntax {
	GetMethod(String n, String ret){
		super(n);
		syntaxString = ret + " " + name + "(){\n\t\n}\n";
	}
	GetMethod(String n, String ret, String[] modifier){
		super(n);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		syntaxString += ret + " " + name + "(){\n\t\n}\n";
	}
}
