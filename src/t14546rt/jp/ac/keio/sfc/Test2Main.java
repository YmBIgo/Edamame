package t14546rt.jp.ac.keio.sfc;

public class Test2Main{
	public static void main(String args[]){
		MainEditor main = new MainEditor();
		main.open();
		

		//テスト
//		TestPage ts = new TestPage();
//		ts.newPage();
		//Get~系テスト
//		String[] modifier = {"private", "static"};
//		String[] imple = {"test", "test2", "test3"};
//		GetInterface gi = new GetInterface("hoge", modifier);
//		System.out.println(gi.get());
//		GetClass gc = new GetClass("hoge", modifier, "superclass", imple);
//		System.out.println(gc.get());
//		GetMethod gm = new GetMethod("hoge", "void", modifier);
//		System.out.println(gm.get());
//		GetVariable gv = new GetVariable("hoge", "String", "value");
//		System.out.println(gv.get());
//		GetIf gif = new GetIf("condition", false);
//		System.out.println(gif.get());
//		String[] con = {"aaa","bbb"};
//		GetIf gif2 = new GetIf(con, 3);
//		System.out.println(gif2.get());
//		GetIf gif3 = new GetIf(con, 3, true, con, 1);
//		System.out.println(gif3.get());
//		GetFor gf = new GetFor("int i=0","i<10","i++");
//		System.out.println(gf.get());
//		GetWhile gw = new GetWhile("condition", false);
//		System.out.println(gw.get());
//		String[] con2 = {"aaa","bbb"};
//		GetWhile gw2 = new GetWhile(con2, 3);
//		System.out.println(gw2.get());
//		GetWhile gw3 = new GetWhile(con2, 3, true, con2, 1);
//		System.out.println(gw3.get());
	}
}

//テスト用
//class TestPage implements ActionListener{
//private static int num = 0;
//private TransitionPage mainWindow;
//private JPanel windowPanel;
//private JButton button;
//TestPage(){
//	mainWindow = new TransitionPage();
//	windowPanel = new JPanel();
//	button = new JButton("次ページへ");
//	button.addActionListener(this);
//	windowPanel.add(button);
//}
//public void newPage(){
//	mainWindow.setBounds(300,300,300,300);
//	mainWindow.add(windowPanel, BorderLayout.CENTER);
//	mainWindow.pack();
//	mainWindow.setVisible(true);
//}
//@Override
//public void actionPerformed(ActionEvent e) {
//	num++;
//	mainWindow.remove(windowPanel);
//	windowPanel = new JPanel();
//	button = new JButton(num + "枚目のページ");
//	button.addActionListener(this);
//	windowPanel.add(button);
//	mainWindow.NextPage(windowPanel);
//}
//
//}