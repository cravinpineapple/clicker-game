package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MenuScreen {

	private JFrame window;

	public MenuScreen(JFrame window) {
		this.window = window;
		window.setTitle("Menu");;
	}
	
	public void init() {
		Container cp = new Container();
		cp.setPreferredSize(new Dimension(300, 300));
		
		
	}
	
}