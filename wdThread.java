package session8;

public class wdThread extends Thread {
	double amount;
	double bal;
	public wdThread(double amount,double bal) {
	// TODO Auto-generated constructor stub
		this.amount=amount;
		this.bal=bal;
	}
	public boolean canTransact() {
		return bal>amount;
	}
	public void run() {
		if(canTransact()) {
			System.out.println("Withdrawing "+amount);
			bal-=amount;
			
			
		}
		else {
			System.out.println("Cannot withdraw");
			System.exit(1);
		}
	}
}
