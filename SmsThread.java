package session8;

public class SmsThread extends Thread {
	String msg;
	public SmsThread(String msg) {
		this.msg=msg;
	}
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sending SMS notification which reads:");
		System.out.println(msg);
		PrintToFileThread p1=new PrintToFileThread(msg+"\n");
		p1.start();
	}
}
