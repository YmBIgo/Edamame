package t14546rt.jp.ac.keio.sfc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class MainEditor extends JFrame implements ActionListener {
	JTextArea text_field;
	SubEditor frame2;
	MainEditor(){
		JButton save_button    = new JButton("Save");
		JButton new_button     = new JButton("Open");
		JButton window_button  = new JButton("Window");
		text_field   = new JTextArea();
		
		//イベントの追加
		save_button.addActionListener(this);
		new_button.addActionListener(this);
		window_button.addActionListener(this);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout());
		
		p.add(save_button);
		p.add(new_button);
		p.add(window_button);
		
		// text_field の大きさ
		text_field.setMargin(new Insets(20,50,20,50));
		// text_field の文字
		text_field.setBackground(Color.BLACK);
		text_field.setFont(new Font("SansSerif", Font.PLAIN,15));
		text_field.setForeground(Color.WHITE);
		text_field.setCaretColor(Color.WHITE);
		
		text_field.getDocument().addDocumentListener(new MyDocumentListener());
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(text_field);
		
		getContentPane().add(p, BorderLayout.SOUTH);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event){
		String command = event.getActionCommand();
		JFileChooser filechooser = new JFileChooser();
		if(command.equals("Save")){
			String save_data = text_field.getText();
			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			try{
				int selected = filechooser.showSaveDialog(this);
				File file = filechooser.getSelectedFile();
				FileWriter filewriter = new FileWriter(file);
				System.out.println(save_data);
				filewriter.write(save_data);
				filewriter.close();
			}catch(IOException e){
				JOptionPane.showMessageDialog(this, e);
			}
		}else if(command.equals("Open")){
			int selected = filechooser.showOpenDialog(this);
			// 開くボタンが押された場合の処理
			if(selected == JFileChooser.APPROVE_OPTION){
				try{
					File file = filechooser.getSelectedFile();
					FileReader filereader = new FileReader(file);
					BufferedReader buffered_reader = new BufferedReader(filereader);
					
					String line;
					String open_data = "";
					while((line = buffered_reader.readLine()) != null){
						open_data += line+"\n";
					}
					text_field.setText(open_data);
					buffered_reader.close();
					filereader.close();
				}catch(FileNotFoundException e){
					JOptionPane.showMessageDialog(this, e);
				}catch(IOException e){
					JOptionPane.showMessageDialog(this, e);
				}
			}
		}else if(command.equals("Window")){
			System.out.println("open!");
			SubEditor frame2 = new SubEditor(10,10,500,500, text_field);
			frame2.open();
		}else{
			
		}
	}

	public class MyDocumentListener implements DocumentListener{
		public void insertUpdate(DocumentEvent e){
			try{
				int location = e.getOffset();
				Document doc = e.getDocument();
				String input_doc = doc.getText(location,1);
				System.out.println(input_doc);
				if(input_doc.contains("\u0020")){
					System.out.println("space");
				}else if(input_doc.contains("\n")){
					System.out.println("lien break");
				}
			}
			catch(Exception err){
				System.out.println(err);
			}
		}
		public void changedUpdate(DocumentEvent e){
			
		}
		public void removeUpdate(DocumentEvent e){
			
		}
	}
	
	public void open(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 750, 800);
		setVisible(true);
	}
}
