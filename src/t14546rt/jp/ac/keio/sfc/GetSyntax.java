package t14546rt.jp.ac.keio.sfc;

public class GetSyntax extends GetReservedWord {
	protected String name;
	GetSyntax(String n){
		name = n;
	}
	public String get(){
		return syntaxString;
	}
	
}
