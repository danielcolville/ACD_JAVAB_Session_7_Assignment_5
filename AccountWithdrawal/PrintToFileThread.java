package session7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrintToFileThread extends Thread {
	String msg;
	PrintToFileThread(String msg) {
		this.msg=msg;
	}
	@Override
	public void run() {
		try {
			BufferedWriter br=new BufferedWriter(new FileWriter("log.txt",true));
			br.write(msg);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
