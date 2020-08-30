package model;

public class Clicker {

	public class PassiveClicks {
		int count = 0;
		double price = 0;

		public int getCount() {
			return count;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public void purchased() {
			count++;
			price = price * count;
		}
	}

	private double wallet = 0;	// current amount of click $
	private double walletTotal = 0; // all time click $ gained
	private int totalClicks = 0; // total amount of times clicked
	private double multiplier = 0; // for passive click income
	private int clickPower = 1; // how many click $ per 

	private PassiveClicks[] passiveClickInfo;
	
	public void clicked() {
		totalClicks++;
		wallet += clickPower;
		walletTotal += clickPower;
	}

	public void increaseMultiplier(double multIncrease) {
		multiplier += multIncrease;
	}
	
	void increaseClickPower(int powerIncrease) {
		clickPower += powerIncrease;
	}

	public double getWallet() {
		return wallet;
	}

	public double getWalletTotal() {
		return walletTotal;
	}

	public int getTotalClicks() {
		return totalClicks;
	}

	public double getMultiplier() {
		return multiplier;
	}

	public int getClickPower() {
		return clickPower;
	}

	public PassiveClicks[] getPassiveClickInfo() {
		return passiveClickInfo;
	}

	//public initPrices
	
}