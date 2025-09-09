package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String serverIp = "192.168.110.1"; 
        int port = 3000; 

        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            // 1) 서버에 연결 시도
            socket = new Socket(serverIp, port);
            
            if(socket != null) {
            	System.out.println("서버(" + serverIp + ")와 연결 성공!");
            }
    
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 서버 → 클라이언트
            pw = new PrintWriter(socket.getOutputStream());                          // 클라이언트 → 서버

            while (true) {
                // 3) 서버로 보낼 메시지 입력
                System.out.print("서버로 보낼 메시지 : ");
                String sendMessage = sc.nextLine();
                if ("exit".equalsIgnoreCase(sendMessage)) {
                    System.out.println("연결을 종료합니다.");
                    break;
                }
                pw.println(sendMessage);
                pw.flush();

                // 4) 서버가 보낸 메시지 읽기
                String message = br.readLine();
                if (message == null) break; 
                System.out.println("서버로부터 전달받은 메시지 : " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원 정리
            try {
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
}
