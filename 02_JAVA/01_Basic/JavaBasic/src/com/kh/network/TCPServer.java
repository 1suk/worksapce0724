package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 3000;

        try (
            // 1) 서버 소켓 생성
            ServerSocket server = new ServerSocket(port);
        ) {
            System.out.println("클라이언트 요청을 기다립니다...");

            // 2) 클라이언트 요청 수락
            Socket socket = server.accept();
            InetAddress clientIp = socket.getInetAddress();
            System.out.println(clientIp.getHostAddress() + " 가 연결을 요청함...");

            // 3) 입출력 스트림 준비
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // auto-flush

            // 4) 클라이언트 메시지 수신
            String message = br.readLine();
            System.out.println("클라이언트로부터 전달받은 메시지 : " + message);

            // 5) 서버가 응답할 메시지 입력
            System.out.print("클라이언트로 보낼 내용 : ");
            String sendMessage = sc.nextLine();

            // 6) 클라이언트로 메시지 전송
            pw.println(sendMessage);

            // 7) 자원 정리
            br.close();
            pw.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
