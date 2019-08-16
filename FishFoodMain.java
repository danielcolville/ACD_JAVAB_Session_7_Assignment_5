package session7;

import java.util.Scanner;

public class FishFoodMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter an integer for the program output");
		int x=sc.nextInt();
		for(int i=1;i<=x;i++) {
			if(i%2==0) {
				twoThread tw=new twoThread();
				tw.start();
				synchronized(tw) {
					try {
						tw.wait();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			else if(i%3==0) {
				threeThread th=new threeThread();
				th.start();
				synchronized(th) {
					try {
						th.wait();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			else if(i%5==0) {
				fiveThread fv=new fiveThread();
				fv.start();
				synchronized(fv) {
					try {
						fv.wait();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				numThread nm=new numThread(i);
				nm.start();
				synchronized(nm) {
					try {
						nm.wait();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	static class twoThread extends Thread{
		@Override
		public void run() {
			synchronized(this) {
				System.out.println("FOOD");
				notify();
			}
		}
	}
	static class threeThread  extends Thread{

		@Override
		public void run() {
			synchronized(this) {
				System.out.println("FISH");
				notify();
			}
		}
	}
	static class fiveThread extends Thread {

		@Override
		public void run() {
			synchronized(this) {
				System.out.println("FOOD FOR FISH");
				notify();
			}
		}
		
	}
	static class numThread extends Thread {
		int num;
		public numThread(int num) {
			this.num=num;
		}
		@Override
		public void run() {
			synchronized(this) {
				System.out.println(num);
				notify();
			}
		}
	}

}
