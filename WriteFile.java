package session7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile extends Thread{
	public void run() {
		File f=new File("out.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter br=new BufferedWriter(new FileWriter(f));
			br.write("This is a string of text with a few digits 123124138501");
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
