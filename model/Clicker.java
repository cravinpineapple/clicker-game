package model;

public class Clicker {

	private double wallet = 0;	// current amount of click $
	private double walletTotal = 0; // all time click $ gained
	private int totalClicks = 0; // total amount of times clicked
	private double multiplier = 0; // for passive click income
	private int clickPower = 1; // how many click $ per 
	
	void clicked() {
		totalClicks++;
		wallet += clickPower;
		walletTotal += clickPower;
	}

	void increaseMultiplier(double multIncrease) {
		multiplier += multIncrease;
	}
	
	void increaseClickPower(int powerIncrease) {
		clickPower += powerIncrease;
	}
	
}