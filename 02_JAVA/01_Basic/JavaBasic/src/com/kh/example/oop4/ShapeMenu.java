package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {

    private Scanner sc = new Scanner(System.in);
    private SquareController scr = new SquareController();
    private TriangleController tc = new TriangleController();

    public void inputMenu() {
        while (true) { // 메인 메뉴 반복
            System.out.println("==== 도형 프로그램 =====");
            System.out.println("3. 삼각형");
            System.out.println("4. 사각형");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴번호 : ");

            int select = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (select) {
                case 3:
                    triangleMenu();
                    break;
                case 4:
                    squareMenu();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return; // 프로그램 종료
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void triangleMenu() {
        while (true) { // 삼각형 메뉴 반복
            System.out.println("==== 삼각형 =====");
            System.out.println("1. 삼각형 면적");
            System.out.println("2. 삼각형 색칠");
            System.out.println("3. 삼각형 정보");
            System.out.println("9. 메인으로");
            System.out.print("메뉴번호 : ");

            int menuNum = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menuNum) {
                case 1:
                	inputSize(3, menuNum);
                	break;
                case 2:
                	inputSize(3, 3);
                	break;
                case 3:
                	printInformation(3);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void squareMenu() {
        while (true) { // 사각형 메뉴 반복
            System.out.println("==== 사각형 =====");
            System.out.println("1. 사각형 둘레");
            System.out.println("2. 사각형 면적");
            System.out.println("3. 사각형 색칠");
            System.out.println("4. 사각형 정보");
            System.out.println("9. 메인으로");
            System.out.print("메뉴번호 : ");

            int menuNum = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menuNum) {
                case 1:
                	 inputSize(4, 1);
                     break;
                case 2:
                	 inputSize(4, menuNum);
                     break;
                case 3:
                	inputSize(4, 3);
                case 4:
                    printInformation(4);
                    break;
                case 9:
                    return; // 메인 메뉴로 복귀
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void inputSize(int type, int menuNum) {
        switch (menuNum) {
            case 1: {
                System.out.print("높이 : ");
                double height = sc.nextDouble();
                System.out.print("너비 : ");
                double width = sc.nextDouble();

                if (type == 4) {
                    double perimeter = scr.calcPerimeter(height, width);
                    System.out.println("사각형의 둘레 : " + perimeter);
                }else if(type ==3) {
                	double area = tc.calcArea(height, width);
                    System.out.println("삼각형의 넓이 : " + area);
                }
            }
            break;

            case 2: {
                System.out.print("높이 : ");
                double height = sc.nextDouble();
                System.out.print("너비 : ");
                double width = sc.nextDouble();

                double area;
                if (type == 3) {
                    area = tc.calcArea(height, width);
                    System.out.println("삼각형의 넓이 : " + area);
                } else {
                    area = scr.calcArea(height, width);
                    System.out.println("사각형의 넓이 : " + area);
                }
            }
            break;

            case 3: {
                System.out.print("색깔을 입력하세요 : ");
                String color = sc.next();
                if (type == 3) {
                    tc.paintColor(color);
                } else {
                    scr.paintColor(color);
                }
            }
            break;
        }
    }

    public void printInformation(int type) {
        if (type == 3) {
            System.out.println(tc.print());
        } else {
            System.out.println(scr.print());
        }
    }

    public static void main(String[] args) {
        ShapeMenu menu = new ShapeMenu();
        menu.inputMenu();
    }
}
