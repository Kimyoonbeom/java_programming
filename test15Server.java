package assignments;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class test15Server extends JFrame {
	ArrayList<String> wordList = new ArrayList<String>();
	JTextArea ta = new JTextArea();
	
	public test15Server() {
		readWordList();
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(ta);
		ta.setEnabled(false);
		ta.setDisabledTextColor(Color.black);
		
		setTitle("영어 단어 체크 서버");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		try {
			ServerSocket ss = new ServerSocket(9999);
			
			while(true) {
				Socket socket = ss.accept();
				ta.append("클라이언트 접속됨!"+"\n");
				Multiple multi = new Multiple(socket);
				multi.start();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readWordList() {
		File file = new File("C:\\Users\\MOMO\\eclipse-workspace\\words.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while(true) {
				String word = br.readLine();
				if(word == null)
					break;
				wordList.add(word);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	class Multiple extends Thread{
		
		Socket socket;
		
		public Multiple(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				while(true) {
					String receiveWord = br.readLine();
					if(receiveWord == null)
						break;
					
					if(wordList.indexOf(receiveWord) >= 0) {
						ta.append(receiveWord+"=Yes"+"\n");
						bw.write("네" + "\n");
						bw.flush();
					}
					else {
						ta.append(receiveWord+"=No"+"\n");
						bw.write("아니요" + "\n");
						bw.flush();
					}
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new test15Server();
	}
}


