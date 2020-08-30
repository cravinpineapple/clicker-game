package control;

import java.awt.event.ActionListener;

import view.MarketScreen;

import java.awt.event.ActionEvent;

public class MarketClickListener implements ActionListener{

	private MarketScreen panel;

	public MarketClickListener(MarketScreen panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();

		//if (button )

	}
	
}