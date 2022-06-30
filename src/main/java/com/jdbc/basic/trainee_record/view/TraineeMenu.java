package com.jdbc.basic.trainee_record.view;

import com.jdbc.basic.trainee_record.controller.TraineeController;

import java.util.Scanner;

public class TraineeMenu {

    private final TraineeController controller;
    private final Scanner sc;

    public TraineeMenu(){
        controller = new TraineeController();
        sc = new Scanner(System.in);
    }

    public void  mainManu(){
        while (true) {
            System.out.println("\n===== 나는 어제의 나보다 1.1배 강해진다 =====");
            System.out.println("\n# 미래경찰 체력 학원에 오신 것을 환영합니다");
            System.out.println("# 1. 새 수강생 등록");
            System.out.println("# 2. 수강생 전체 조회");
            System.out.println("# 3. 수강생 개별 조회");
            System.out.println("# 4. 수강생 정보 수정");
            System.out.println("# 5. 수강생 기록 갱신");
            System.out.println("# 6. 수강생 정보 삭제");
            System.out.println("# 9. 끝내기");

            int menu = inputNum("\n 메뉴 입력: ");

            switch (menu) {
                case 1:
                    insertMenu();
                    break;
                case 2:
//                    findAllMenu();
                    break;
                case 3:
//                    findOneMenu();
                    break;
                case 4:
//                    modifyMenu();
                    break;
                case 5:
//                    updateMenu();
                case 6:
//                    removeMenu();
                    break;
                case 9:
                    System.out.println("\n# 프로그램을 종료합니다");
                    System.out.println("\n# 빠잉~");
                    return;

            }
        }
    }

//   case 1. 새 수강생 등록
    private void insertMenu() {
        System.out.println("\n# 새 수강생을 등록합니다~");


    }

    // 메세지 출력과 숫자 입력을 동시에
    private int inputNum(String msg) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("# 메뉴 번호를 입력해 주세요");
            }
        }
        return n;
    }

    // 메세지 출력과 문자열 입력을 동시에
    private String inputStr(String msg) {
        String s;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.next();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("# 다시 입력해 주세요");
            }
        }
        return s;
    }

}
