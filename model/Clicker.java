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

	static PassiveClicks[] passiveClickInfo = new PassiveClicks[4]; // tracks passiveClick price & count

	private boolean hasCert = false;
	private boolean hasBS = false;
	private boolean hasMS = false;
	private boolean hasPHD = false;
	
	public void clicked() {
		totalClicks++;
		wallet += clickPower;
		walletTotal += clickPower;
	}

	public void increaseMultiplier(double multIncrease) {
		multiplier += multIncrease;
	}
	
	public void increaseClickPower(int powerIncrease) {
		clickPower += powerIncrease;
	}

	public double getWallet() {
		return wallet;
	}

	public void subtWallet(double subtAmount) {
		wallet -= subtAmount;
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

	static public PassiveClicks[] getPassiveClickInfo() {
		return passiveClickInfo;
	}

	//sets the price of each passiveClickIncome 
	public void initPassiveClickInfo() {
		for (int i = 0; i < 4; i++) 
			passiveClickInfo[i] = new PassiveClicks();
		
		passiveClickInfo[0].setPrice(30);
		passiveClickInfo[1].setPrice(500);
		passiveClickInfo[2].setPrice(1000);
		passiveClickInfo[3].setPrice(5000);
	}

	public boolean getHasPower(int index) {
		switch (index) {
			case 0:
				return hasCert;
			case 1:
				return hasBS;
			case 2:
				return hasMS;
			case 3:
				return hasPHD;
			default:
				return false;
		}
	}

	public void setHasPower(int index, boolean value) {
		switch (index) {
			case 0:
				hasCert = value;
			case 1:
				hasBS = value;
			case 2:
				hasMS = value;
			case 3:
				hasPHD = value;
		}
	}


	
}