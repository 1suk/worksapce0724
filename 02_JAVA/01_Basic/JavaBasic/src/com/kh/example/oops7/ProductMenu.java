package com.kh.example.oops7;

import java.util.Scanner;

public class ProductMenu {
    Scanner sc = new Scanner(System.in);
    ProductController pc = new ProductController();

    public void mainMenu() {
        while (true) {
            System.out.println("======상품 관리 메뉴======");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 전체 조회");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 번호 : ");

            int select = sc.nextInt();
            sc.nextLine(); // 개행 문자 제거

            switch (select) {
                case 1:
                    System.out.print("추가할 상품명: ");
                    String pName = sc.nextLine();
                    System.out.print("추가할 가격: ");
                    int price = sc.nextInt();
                    sc.nextLine(); // 개행 문자 제거
                    System.out.print("추가할 브랜드: ");
                    String brand = sc.nextLine();

                    pc.insertProduct(pName, price, brand);
                    System.out.println("상품이 추가되었습니다.\n");
                    break;

                case 2:
                    Product[] pro = pc.selectProduct();
                    System.out.println("======상품 목록======");
                    for (Product p : pro) {
                        if (p == null) break;
                        System.out.println(p.inform());
                    }
                    System.out.println();
                    break;

                case 9:
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
            }
        }
    }
}
