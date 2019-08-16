package session7;

import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ReadFile extends Thread {
	ArrayList<Character> vowels;
	ArrayList<Character> cons;
	ArrayList<Character> digs;
	public ReadFile(ArrayList<Character> vowels,ArrayList<Character> cons,ArrayList<Character> digs) {
		this.vowels=vowels;
		this.cons=cons;
		this.digs=digs;
	}
	public void run() {
		File f=new File("out.txt");
		if(!f.exists()) {
			System.out.println("Some error has occured:file not present");
		}
		
		HashSet<Character> vList=new HashSet<Character>();
		vList.addAll(Arrays.asList('a','e','i','o','u'));
		
		HashSet<Character> cList=new HashSet<Character>();
		cList.addAll(Arrays.asList('b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'));
		HashSet<Character> dList=new HashSet<Character>();
		dList.addAll(Arrays.asList('1','2','3','4','5','6','7','8','9'));
		synchronized(this) {
			try {
				Reader r=new FileReader(f);
				char c;
				int a;
				while( (a=r.read()) !=-1) {
					c=(char) a;
					//System.out.println(c);
					if(dList.contains(c)) {
						digs.add(c);
					}
					else if(vList.contains(c)) {
						vowels.add(c);
					}
					else if(cList.contains(c)) {
						cons.add(c);
					}
				}
				
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
		}
		System.out.println("The vowels being written to file:");
		for(Character c:vowels) {
			System.out.print(c);
		}
		System.out.println("\nThe digits being written to file:");
		for(Character c:digs) {
			System.out.print(c);
		}
		System.out.println("\nThe consonants being written to file:");
		for(Character c:cons) {
			System.out.print(c);
		}
	}
}
