package model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import view.ClickerSimulator;
import view.MarketScreen;

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
			price = Math.round((price * 1.25) * 10) / 10.0;
		}
	}

	private double wallet = 0;	// current amount of click $
	private double walletTotal = 0; // all time click $ gained
	private int totalClicks = 0; // total amount of times clicked
	private double totalCatClicksEarned = 0;
	private double totalClickCoinMinerEarned = 0;
	private double totalClickIncEarned = 0;
	private double totalClickMutantEarned = 0;
	//private double multiplier = 0; // for passive click income
	private int clickPower = 1; // how many click $ per 

	public static PassiveClicks[] passiveClickInfo = new PassiveClicks[4]; // tracks passiveClick price & count

	private boolean hasCert = false;
	private boolean hasBS = false;
	private boolean hasMS = false;
	private boolean hasPHD = false;

	//clickSim to update wallet text within timer
	ClickerSimulator clickSim;
	MarketScreen marketScreen;

	// variables for cps
	double clicksPerSecond = 0;
	Timer timer;

	// increases CPS whenever item purchased
	public void updateTimer(double cpsIncrease) {
		clicksPerSecond += cpsIncrease;
	}

	public void setTimer() {
		timer = new Timer(1000, new ActionListener() { // 1000 milliseconds (1 second)

			@Override
			public void actionPerformed(ActionEvent e) {
				double walletRounded = Math.round(wallet * 10) / 10.0;
				addWallet(clicksPerSecond);
				if (passiveClickInfo[0].count != 0)
					totalCatClicksEarned += 0.1;
				if (passiveClickInfo[1].count != 0)
					totalClickCoinMinerEarned += 1;
				if (passiveClickInfo[2].count != 0)
					totalClickIncEarned += 5;
				if (passiveClickInfo[3].count != 0)
					totalClickMutantEarned += 20;
				clickSim.getWalletText().setText("Wallet: " + walletRounded);

				walletTotal += (passiveClickInfo[0].getCount() * 0.1) + (passiveClickInfo[1].getCount() * 1) + (passiveClickInfo[2].getCount() * 10) + (passiveClickInfo[3].getCount() * 100);

				if (marketScreen != null)
					marketScreen.getWalletText().setText("Wallet: " + walletRounded);
			}
		}); 
	}
	
	public Clicker(ClickerSimulator clickSim) {
		this.clickSim = clickSim;
		setTimer();
		timer.start();
	}

	public void updateMarketScreen(MarketScreen marketScreen) {
		this.marketScreen = marketScreen;
	}

	public void clicked() {
		totalClicks++;
		wallet += clickPower;
		walletTotal += clickPower;
	}

	public void increaseCPS(double multIncrease) {
		clicksPerSecond += multIncrease;
	}
	
	public void setClickPower(int powerIncrease) {
		if (powerIncrease < clickPower)
			return;

		clickPower = powerIncrease;
	}

	public double getWallet() {
		return wallet;
	}

	public void subtWallet(double subtAmount) {
		wallet -= subtAmount;
	}

	public void addWallet(double addAmount) {
		wallet += addAmount;
		walletTotal += addAmount;
	}

	public double getWalletTotal() {
		return walletTotal;
	}

	public int getTotalClicks() {
		return totalClicks;
	}

	public double getCPS() {
		return clicksPerSecond;
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
		
		passiveClickInfo[0].setPrice(1);
		passiveClickInfo[1].setPrice(10);
		passiveClickInfo[2].setPrice(50);
		passiveClickInfo[3].setPrice(100);
	}

	public boolean getHasCert() {
		return hasCert;
	}

	public boolean getHasBS() {
		return hasBS;
	}

	public boolean getHasMS() {
		return hasMS;
	}

	public boolean getHasPHD() {
		return hasPHD;
	}

	public void setHasCert(boolean value) {
		hasCert = value;
	}

	public void setHasBS(boolean value) {
		hasBS = value;
	}

	public void setHasMS(boolean value) {
		hasMS = value;
	}

	public void setHasPHD(boolean value) {
		hasPHD = value;
	}	

	public void setClickSim(ClickerSimulator clickSim) {
		this.clickSim = clickSim;
	}

	public double getTotalCatClicksEarned() {
		return totalCatClicksEarned;
	}

	public double getTotalClickCoinMinerEarned() {
		return totalClickCoinMinerEarned;
	}

	public double getTotalClickIncEarned() {
		return totalClickIncEarned;
	}

	public double getTotalClickMutantEarned() {
		return totalClickMutantEarned;
	}
}