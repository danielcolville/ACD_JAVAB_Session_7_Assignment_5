package session7;

public class AccountWithdrawalMain {

	public static void main(String[] args) {
		wdThread wd=new wdThread(100,1000);
		wd.start();
		synchronized(wd) {
			try {
				wd.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String smsMsg="Your withdrawal was sucessful ";
		String emailMsg="This email is to inform you that your withdrawal was sucessful. If this was not you call the fraud helpline.";
		SmsThread sm=new SmsThread(smsMsg);
		EmailThread em=new EmailThread(emailMsg);
		sm.start();
		
		em.start();
		synchronized(sm ) {
			try {
				sm.wait();
				PrintToFileThread p1=new PrintToFileThread(smsMsg+"\n");
				p1.start();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				PrintToFileThread p2=new PrintToFileThread(emailMsg+"\n");
				p2.start();
			
		
	}

}
