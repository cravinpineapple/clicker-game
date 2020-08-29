package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuScreen {

	private JFrame window;

	public MenuScreen(JFrame window) {
		this.window = window;
		window.setTitle("Menu");;
	}
	
	public void init() {
		// container to add our components to
		Container cp = window.getContentPane();
		cp.setPreferredSize(new Dimension(500, 300)); // sets window size
		
		// panel for menu text
		JPanel northPanel = new JPanel();
		// html stuff for line break
		JLabel menuText = new JLabel("<html>The world's currency has been converted to mouse clicks!<br/>" + 
									 "Do you have what it takes to live in this click-eat-click world?</html>");
		northPanel.add(menuText); // adds text to northPanel
		cp.add(BorderLayout.NORTH, northPanel); // adds north panel to content pane

		JPanel southPanel = new JPanel(); // panel for yes/no buttons
		southPanel.setLayout(new GridLayout(2, 1)); // sets layout for buttons
		JButton yesButton = new JButton("Lets do it!");
		JButton noButton = new JButton("I don't want carpal tunnel syndrome...");
		southPanel.add(yesButton);
		southPanel.add(noButton);
		cp.add(BorderLayout.CENTER, southPanel); // adds panel for buttons to content pane
	}
	
}