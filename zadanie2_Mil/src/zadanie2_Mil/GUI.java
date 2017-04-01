package zadanie2_Mil;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GUI {
		
	public void perform() {
				
		JFrame window = setFrame();
		JPanel panel = setPanel(window);
		JLabel label = setLabel(panel);
		JButton readFileButton = setReadFileButton();
		JButton resultButton = setResultButton(label);
		JPanel subPanel = setSubPanel();
		addToSubPanel(subPanel, readFileButton);
		addToSubPanel(subPanel, resultButton);
		setfinalPanel(subPanel, panel);
	}
	
	void setfinalPanel(JPanel subPanel, JPanel panel) {
		panel.add(subPanel, BorderLayout.SOUTH);
	}
	
	void addToSubPanel(JPanel subPanel, JButton button) {
		subPanel.add(button);
	}
	
	JPanel setSubPanel() {
		return new JPanel();
	}
	
	JFrame setFrame() {
		JFrame window = new JFrame("Zadanie 2");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		window.setSize(250,250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return window;
	}
	
	JPanel setPanel(JFrame window) {
		JPanel panel = new JPanel(new BorderLayout());
		window.add(panel);
		return panel;
	}
	
	
	JLabel setLabel(JPanel c) {
		JLabel label = new JLabel("", SwingConstants.CENTER);
		label.setBounds(0, 10, 300, 20);
		c.add(label, BorderLayout.CENTER);
			
		return label;
	}
	
	JButton setReadFileButton() {
		JButton readFileButton = new JButton("Wczytaj dane");
		
		readFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser openFile = new JFileChooser();
					File workingDirectory = new File(System.getProperty("user.dir"));
	                openFile.setCurrentDirectory(workingDirectory);
	                openFile.showOpenDialog(null);
	                
	                //String fileName = openFile.getSelectedFile().getName();
	                String fileName = openFile.getSelectedFile().getAbsolutePath();
					Data.data = FileManager.loadData(fileName);
					System.out.println("Wczytano dane.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		return readFileButton;
	}
	
	JButton setResultButton(JLabel label) {
		JButton resultButton = new JButton("Wynik"); 
		resultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				label.setText(String.valueOf(Main.calculate(Data.data)));
			}
		});
		
		return resultButton;
	}
} 