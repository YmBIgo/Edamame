package t14546rt.jp.ac.keio.sfc;

public class GetInterface extends GetSyntax{
	GetInterface(String n, String[] modifier){
		super(n);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		syntaxString += makeSyntax(name);
	}
	private String makeSyntax(String name){
		String result = "interface " + name +  " {\n\t\n}\n";
		return result;
	}
}
