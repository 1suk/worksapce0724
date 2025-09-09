package com.kh.io1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader; // 추가
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;


public class ServerStream {
    /*
     * 보조스트림
     * 외부매체와 직접 연결되지 않고, 기반스트림을 감싸서 기능/성능을 높여줌
     * ex) new BufferedWriter(new FileWriter(경로));
     *   FileWriter : 파일을 직접적으로 연결해서 2바이트 단위로 출력할 수 있는 기반 스트림
     *   BufferedWriter : 편의성과 속도향상에 도움을 주는 보조스트림(기반 스트림 없이 사용 불가)
     */

    // 1. 간단히 파일 저장
    public void fileSave() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("1_buffer.txt"))) {
            bw.write("안녕하세요");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. 스트림 체인 방식으로 저장
    public void fileSaveWithStream() {
        try {
            // 1. 기반스트림 생성
            FileOutputStream fo = new FileOutputStream("1_buffer.txt");
            // 2. OutputStream을 문자 단위 Writer로 감싸기 (인코딩 지정 가능)
            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF-8");
            // 3. 버퍼링 기능 추가
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("안녕하세요.\n");
            bw.write("BufferedWriter + OutputStreamWriter 예제입니다.");
            bw.close(); // try-with-resource 안 썼으니 수동 close
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. 파일 읽기
    public void fileRead() {
        try (BufferedReader br = new BufferedReader(new FileReader("1_buffer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * 직렬화
     * 객체는 메모리안에서 존재하는 인스턴스 개념이기 떄문에 그대로 전송할 수 없음, 직렬화 후 이진데이터로 외부에 전송 가능.
     * - 객체(Object)를 바이트 형태로 변환하는 과정.
     * - 파일에 저장하거나 네트위크로 전송할 수 있도록 함
     * - 자바에서는 클래스를 직렬화하기위해 직렬화 대상클래스에게는 implements Serializable 해야함
     * 
     * 역질렬화
     * 저장해 두거나 전송했던 데이터를 다시 원래 객체처럼 사용하기위해 역직렬화를 진행함.
     * -저장된 바이트 데이터를 다시 객체로 복원하는 과정
     * 
     * 프로그램 -> 파일(출력) : 객체(직렬화)
     * */
    
    public void objectSave() {
        Product p1 = new Product("아이폰16mini", 1000000);
        Product p2 = new Product("아이폰16", 1200000);
        Product p3 = new Product("아이폰16Pro", 1800000);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product1.dat"))) {
            oos.writeObject(p1); // 직렬화후 객체로 저장
            oos.writeObject(p2);
            oos.writeObject(p3);
            System.out.println("객체 저장 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void objectRead() {
 
        try (ObjectIntputStream ois = new ObjectInputStream(new FileInputStream("product1.dat"))) {
            Object obj = ois.readObject(p1); //Object
            if(obj instanceof Product) {
            	Product p1 = (Product)obj;
            	System.out.println(p1);
            }
            System.out.println("객체 저장 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
        	System.out.println("에러 : 직렬화 대상 클래스를 찾을 수 없습니다");
        	e.printStackTrace();
        }
    }

}
