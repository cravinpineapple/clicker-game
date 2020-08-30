package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ClickerSimulator;
import view.MenuScreen;

public class ButtonClickListener implements ActionListener {

	private ClickerSimulator panel;

	public ButtonClickListener(ClickerSimulator panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();

		if (button == panel.getExitButton()) {
			panel.getWindow().getContentPane().removeAll();
			var menuSim = new MenuScreen(panel.getWindow());
			menuSim.init();
			panel.getWindow().pack();
			panel.getWindow().revalidate();
		}
	}
	
}