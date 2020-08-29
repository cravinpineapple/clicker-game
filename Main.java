import javax.swing.JFrame;

import view.MenuScreen;

public class Main {
	public static void main(String[] args) {

		// creates our window and sets where it appears on screen
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(350, 200);

		// sets our window to the menu screen and initializes it
		var menu = new MenuScreen(window);
		menu.init();

		//condenses window to fit to it's components and sets window to be visible.
		window.pack();
		window.setVisible(true);
	}
}