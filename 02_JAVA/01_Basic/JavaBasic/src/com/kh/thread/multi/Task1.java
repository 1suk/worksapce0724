package com.kh.thread.multi;

public class Task1 extends Thread {
	public void run() {
		try {
			for(int i=0; i<=20; i++) {
				if(i%2==1) {
					System.out.print(i + " ");
				}
				Thread.sleep(400);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}	
}

