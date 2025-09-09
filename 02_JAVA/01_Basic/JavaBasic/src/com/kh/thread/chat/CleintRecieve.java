package com.kh.thread.chat;

public class CleintRecieve extends Thread {
	private Socket socket;
	
	public CleintReceive(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run() {
		//스레드를 통해서 메세지를 받아서 출력
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInput()));
			
		}catch() {
			
		}
	}
}
