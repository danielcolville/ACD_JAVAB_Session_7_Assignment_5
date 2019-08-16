package session7;

import java.util.ArrayList;

public class VowelConsMain {
	static ArrayList<Character> vowels=new ArrayList<Character>();
	static ArrayList<Character> cons=new ArrayList<Character>();
	static ArrayList<Character> digs=new ArrayList<Character>();
	public static void main(String[] args) {
		WriteFile wf=new WriteFile("out.txt");
		wf.start();
		synchronized(wf) {
			try {
				wf.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ReadFile rf=new ReadFile(vowels,cons,digs);
		rf.start();
		synchronized(rf) {
		try {
			rf.wait();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		WriteFile consWrite=new WriteFile("consonants.txt",cons);
		WriteFile vwlWrite=new WriteFile("vowels.txt",vowels);
		WriteFile digWrite=new WriteFile("digits.txt",digs);
		consWrite.start();
		vwlWrite.start();
		digWrite.start();
	}

}
