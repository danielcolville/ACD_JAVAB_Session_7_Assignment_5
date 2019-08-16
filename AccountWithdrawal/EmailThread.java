package session7;

public class EmailThread  extends Thread{
	String msg;
	public EmailThread(String msg) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
	}
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sending email notification which reads:");
		System.out.println(msg);

	}
}
