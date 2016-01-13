package t14546rt.jp.ac.keio.sfc;

public class GetFor extends GetControl {
	GetFor(String value1,String value2,String value3){
		syntaxString = "for(";
		syntaxString += value1 + ";" + value2 + ";" + value3;
	}
}