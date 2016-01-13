package t14546rt.jp.ac.keio.sfc;

public class GetControl {
	protected String syntaxString;
	GetControl(){}
	protected String switcher(String value1, String value2, int num){
		String tmp = "";
		switch(num){
		case 0: // "=="
			tmp = value1 + "==" + value2;
			break;
		case 1: // "!="
			tmp = value1 + "!=" + value2;
			break;
		case 2: // "<="
			tmp = value1 + "<=" + value2;
			break;
		case 3: // ">="
			tmp = value1 + ">=" + value2;
			break;
		case 4: // "<"
			tmp = value1 + "<" + value2;
			break;
		case 5: // ">"
			tmp = value1 + ">" + value2;
			break;
		default:
			break;
		}
		return tmp;
	}
	public String get(){
		syntaxString += "){\n\t\n}\n";
		return syntaxString;
	}
}
