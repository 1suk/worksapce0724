package com.kh.thread.chat;

import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread {
	private Socket socket;

	public ClientSend() {
		super();
		this.socket = socket;
	}
	
	public void run() {
		try(Scanner sc = new Scanner(System.in)){
			
			PrinterWriter pw = new PrintWrite(socket.getOutputStream());
		}catch() {
			
		}
	}
}
