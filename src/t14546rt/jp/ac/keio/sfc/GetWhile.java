package t14546rt.jp.ac.keio.sfc;

public class GetWhile extends GetControl {
	GetWhile(String value){
		super();
		syntaxString = "while(";
		syntaxString += value;
	}
	GetWhile(String value, boolean con){
		super();
		syntaxString = "while(";
		if(con){
			syntaxString += value;
		}else{
			syntaxString += "!" + value;
		}
	}
	GetWhile(String[] value, int con ){
		super();
		syntaxString = "while(";
		syntaxString += switcher(value[0], value[1], con);
	}
	GetWhile(String[] value1, int con1, boolean logic, String[] value2, int con2){
		super();
		syntaxString = "while(";
		syntaxString += switcher(value1[0], value1[1], con1);
		if(logic) syntaxString += "&&";
		else syntaxString += "||";
		syntaxString += switcher(value2[0], value2[1], con2);
	}
}
