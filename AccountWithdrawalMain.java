package session8;

public class AccountWithdrawalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wdThread wd=new wdThread(100,1000);
		wd.start();
		SmsThread sm=new SmsThread("Your withdrawal was sucessful in amount ");
		EmailThread em=new EmailThread("Your withdrawal was sucessful more email message if this was not you notify us etc.");
		sm.start();
		
		em.start();
		
	}

}
