package session7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile extends Thread{
	String filename;
	ArrayList<Character>out;
	public WriteFile(String filename) {
		this.filename=filename;
	}
	public WriteFile(String filename,ArrayList<Character > out) {
		 this.filename=filename;
		 this.out=out;
	}
	public void run() {
		File f=new File(filename);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter br=new BufferedWriter(new FileWriter(f));
			if(out==null) {
				br.write("This is a string of text with a few digits 123124138501");
			}
			else {
				for(Character c:out) {
					br.write(c);
				}
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
