package t14546rt.jp.ac.keio.sfc;

public class GetClass extends GetSyntax{
	GetClass(String n, String[] modifier, String ext, String[] imple){
		super(n);
		syntaxString = "";
		for(int i=0;i<modifier.length;i++){
			syntaxString += modifier[i] + " ";
		}
		String tmp = "";
		if(!(ext.equals(""))){
			tmp = "extends " + ext + " ";
		}
		String add = "";
		if(imple.length >= 1){
			add = "implements ";
		}
		for(int i=0;i<imple.length;i++){
			add += imple[i];
			if(i != imple.length-1) add += ", ";
		}
		syntaxString += makeSyntax(name, tmp + add);
	}
	
	
	private String makeSyntax(String name, String add){
		String result = "class " + name + " " + add + " {\n\t\n}\n";
		return result;
	}
}