
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WordGUI extends JFrame {

	 
	public JButton startButton;
	public static JButton againButton;

	private static void constructGUI() {
		 
		
		 JButton startButton = new JButton("Analyze Text");
		
		//JFrame Content and button
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 JFrame frame = new JFrame("ActionListener");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 frame.setTitle("Click the below button to analyze your text ");
		 frame.setLayout(new GridLayout(2, 2));
		
		 startButton = new JButton("Analyze");
		 startButton.addActionListener(new MyActionListener());
		 frame.getContentPane().add(startButton);
		 frame.add(startButton);
		 
		 againButton = new JButton("Start Again");
		 againButton.addActionListener(new MyActionListener());
		 frame.add(againButton);
		 frame.pack();
		 frame.setVisible(true);
		 
		 int frameWidth = 400;
		 int frameHeight = 200;
		 Dimension screenSize =
		 Toolkit.getDefaultToolkit().getScreenSize();
		 frame.setBounds((int) screenSize.getWidth() - frameWidth, 
		 0, frameWidth, frameHeight);
		 
		 } 
	
	static class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			String line, word = "";    
			int count = 0, maxCount = 0;    
			ArrayList<String> words = new ArrayList<String>();    
			FileReader file = null;
			try {
				file = new FileReader("C:\\Users\\studi\\Documents\\Valencia\\Software Development I\\The Raven.txt");
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}    
			BufferedReader br = new BufferedReader(file);    

			  String line1;
		      HashMap<String, Long> counts = new HashMap<>();
		      try {
				while ((line1 = br.readLine()) != null) {
				      
					  
				      String[] words1 = line1.split("[\\s.;,?:!()\"]+");
				      for (String word1 : words1) {
				          word1 = word1.trim();
				          if (word1.length() > 0) {
				              if (counts.containsKey(word1)) {
				                  counts.put(word1, counts.get(word1) + 1);
				              } else {
				                  counts.put(word1, 1L);
				              }
				          }
				      }
				  }
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		      for (Map.Entry<String, Long> entry : counts.entrySet()) {
		          System.out.println(entry.getKey() + " : " + entry.getValue());
		      }
		      try {
				br.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		  }
			
		}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});
		
		
		} //close main

	} //close class



	