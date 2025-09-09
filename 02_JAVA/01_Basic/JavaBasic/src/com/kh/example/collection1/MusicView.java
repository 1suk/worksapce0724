package com.kh.example.collection1;

import java.util.List;
import java.util.Scanner;
//MusicView
public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	

	    public void mainMenu() {
	    	while(true) {
	    		System.out.println("1. 마지막 위치에 곡 추가");
	    		System.out.println("2. 첫 위치에 곡 추가");
	    		System.out.println("3. 전체 곡 목록 출력");
	    		System.out.println("4. 특정 곡 검색");
	    		System.out.println("5. 특정 곡 삭제");
	    		System.out.println("6. 특정 곡 정보 수정");
	    		System.out.println("7. 곡명 오름차순 정렬");
	    		System.out.println("8. 가수명 내림차순 정렬");
	    		System.out.println("9. 종료 (메시지 출력 후 반환)");
	    		System.out.println("메뉴번호 입력 :");
	    		
	    		int sel = sc.nextInt();
	    		switch(sel) {
	    			case 1:
	    				addList();
	    				break;
	    			case 2:
	    				addAtZero();
	    				break;
	    			case 3:
	    				printAll();
	    				break;
	    			case 4:
	    				searchMusic();
	    				break;
	    			case 5:
	    				removeMusic();
	    				break;
	    			case 6:
	    				setMusic();
	    				break;
	    			case 7:
	    				ascTitle();
	    				break;
	    			case 8:
	    				descSinger();
	    				break;
	    			case 9:
	    				System.out.println("프로그램 종료");
	    				return;
	    			default:
	    				System.out.println("잘못입력하셨습니다.\n");
	    		}
	    		System.out.println();
	    		
	    	}
	    }

	    public void addList() {
	       System.out.println("마지막 위치에 곡 추가");
	       System.out.println("곡 명 : ");
	       String title = sc.nextLine();
	       System.out.println("가수 명 : ");
	       String singer = sc.nextLine();
	       
	       
	       int result = mc.addList(new Music(title, singer));
	       System.out.println(result == 1 ? "추가성공" : "추가실패");
	    }

	    public void addAtZero() {
	    	   System.out.println("첫 위치에 곡 추가");
		       System.out.println("곡 명 : ");
		       String title = sc.nextLine();
		       System.out.println("가수 명 : ");
		       String singer = sc.nextLine();
		   
		       
		       int result = mc.addAtZero(new Music(title, singer));
		       System.out.println(result == 1 ? "추가성공" : "추가실패");
	    }

	    public void printAll() {
	       System.out.println("전체 곡 목록 출력");
	       List<Music> list = mc.printAll();
	       System.out.println(list);
	       //mc.printAll() 결과 목록 출력
	    }

	    public void searchMusic() {
	    	 System.out.println("특정 곡 검색");
		     System.out.println("검색할 곡 명 : ");
		     String title = sc.nextLine();
		     Music m = mc.searchMusic(title);
		     if(m == null) {
		    	 System.out.println("검색한 곡이 없습니다.");
		     }else {
		    	 System.out.println("검색한 곡은" + m.toString() + "입니다.");
		     }
	    }

	    public void removeMusic() {
	    	 System.out.println("특정 곡 삭제");
		     System.out.println("삭제할 곡 명 : ");
		     String title = sc.nextLine();
		     Music m = mc.searchMusic(title);
		     if(m == null) {
		    	 System.out.println("삭제할 곡이 없습니다.");
		     }else {
		    	 System.out.println(m.toString() + "을 삭제했습니다.");
		     }
	    }

	    public void setMusic() {
	        System.out.print("수정할 곡명 입력 : ");
	        String title = sc.nextLine();

	        System.out.print("새 곡명 입력 : ");
	        String newTitle = sc.nextLine();

	        System.out.print("새 가수 입력 : ");
	        String newArtist = sc.nextLine();

	        Music newMusic = new Music(newTitle, newArtist);
	        Music old = mc.setMusic(title, newMusic);

	        if (old != null) {
	            System.out.println("수정 성공 : " + old + " -> " + newMusic);
	        } else {
	            System.out.println("수정할 곡을 찾을 수 없습니다.");
	        }
	    }


	    public void ascTitle() {
	        // mc.ascTitle() 결과에 따라 "정렬 성공 / 정렬 실패"
	    }

	    public void descSinger() {
	        // mc.descSinger() 결과에 따라 "정렬 성공 / 정렬 실패"
	    }
	}
