package t14546rt.jp.ac.keio.sfc;

public class GetIf extends GetControl{
	GetIf(String value){
		super();
		syntaxString = "if(";
		syntaxString += value;
	}
	GetIf(String value, boolean con){
		super();
		syntaxString = "if(";
		if(con){
			syntaxString += value;
		}else{
			syntaxString += "!" + value;
		}
	}
	GetIf(String[] value, int con ){
		super();
		syntaxString = "if(";
		syntaxString += switcher(value[0], value[1], con);
	}
	GetIf(String[] value1, int con1, boolean logic, String[] value2, int con2){
		super();
		syntaxString = "if(";
		syntaxString += switcher(value1[0], value1[1], con1);
		if(logic) syntaxString += "&&";
		else syntaxString += "||";
		syntaxString += switcher(value2[0], value2[1], con2);
	}
}
