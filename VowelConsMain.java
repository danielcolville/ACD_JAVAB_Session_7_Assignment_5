package session7;

import java.util.ArrayList;

public class VowelConsMain {
	static ArrayList<Character> vowels=new ArrayList<Character>();
	static ArrayList<Character> cons=new ArrayList<Character>();
	static ArrayList<Character> digs=new ArrayList<Character>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WriteFile wf=new WriteFile();
		wf.start();
		synchronized(wf) {
			try {
				wf.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ReadFile rf=new ReadFile(vowels,cons,digs);
		rf.start();
		System.out.println(vowels+" ");
	}

}
