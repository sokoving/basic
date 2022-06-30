package com.jdbc.basic.trainee_record.view;

import com.jdbc.basic.trainee_record.controller.TraineeController;
import com.jdbc.basic.trainee_record.domain.Trainee;

import java.util.List;
import java.util.Scanner;

public class TraineeMenu {

    private final TraineeController controller;
    private final Scanner sc;

    public TraineeMenu() {
        controller = new TraineeController();
        sc = new Scanner(System.in);
    }

    public void mainManu() {
        while (true) {
            System.out.println("\n===== 오늘의 나는 어제의 나보다 1.1배 더 강하다 =====");
            System.out.println("====== 미래경찰 체력센터에 오신 것을 환영합니다 ======");
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
                    findAllMenu();
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
                    System.out.println("  빠잉~");
                    return;

            }
        }
    }

    // case 2 수강생 전체 조회
    private void findAllMenu() {
        List<Trainee> traineeList = controller.findAllTrainee();
        System.out.println("\n==================== 전체 수강생 정보 ====================");
        System.out.println("  ID     이름   성별   100m  1000m  sitUp  pushUp  오른손 왼손");
        for (Trainee t : traineeList) {
            System.out.printf("%4d %6s %4s %7.1f %5d  %5d  %5d  %5d %4d\n"
                    , t.getTrNum(), t.getTrName(), t.getTrSex(), t.getRun100(), t.getRun1000(), t.getSitUp(), t.getPushUp(), t.getRightGrip(), t.getLeftGrip());
        }
        System.out.println();

    }

    //   case 1. 새 수강생 등록
    private void insertMenu() {
        System.out.println("\n# 새 수강생을 등록합니다.");
        String name = inputStr("이름 : ");
        String sex = inputSex("성별(M/F) : ");
        System.out.println("\n# 체력 시험 기록을 입력해 주세요");
        double run100 = inputDouble("100m 달리기(초) : ");
        int run1000 = inputNum("1000m 달리기(초) : ");
        int situp = inputNum("윗몸일으키기(회/1분) : ");
        int pushup = inputNum("팔굽혀펴기(회/1분) : ");
        int rightGrip = inputNum("오른손 악력(kg) : ");
        int leftGrip = inputNum("왼손 악력(kg) : ");

        Trainee newT = new Trainee();
        newT.setTrName(name);
        newT.setTrSex(sex);
        newT.setRun100(run100);
        newT.setRun1000(run1000);
        newT.setSitUp(situp);
        newT.setPushUp(pushup);
        newT.setRightGrip(rightGrip);
        newT.setLeftGrip(leftGrip);

        boolean flag = controller.insertTrainee(newT);

        if(flag){
            System.out.printf("\n# [ %s ] 님의 정보가 등록되었습니다\n.", name);
        } else {
            System.out.println("# 회원 등록에 실패했습니다. ");
        }
    }

    // 메세지 출력과 숫자 입력을 동시에
    private int inputNum(String msg) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                if (n <= 0 || n > 1000){
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("정상 범위의 정수를 입력해 주세요");
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
                System.out.println("다시 입력해 주세요");
            }
        }
        return s;
    }

    // 메세지 출력과 실수 입력을 동시에
    private double inputDouble(String msg) {
        double d;
        while (true) {
            try {
                System.out.print(msg);
                d = sc.nextDouble();
                if (d <= 0 || d > 50) {
                    System.out.print("정상 범위의 수가 아닙니다. ");
                    throw new Exception();
                } else {
                    d = (double) Math.round(d * 10) / 10;
                    break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("다시 입력해 주세요");
            }
        }
        return d;
    }

    // 찰떡같은 성별 입력받기
    private String inputSex(String msg) {
        System.out.print(msg);
        while (true) {
            try {
                String s = sc.next();
                switch (s.toUpperCase().charAt(0)) {
                    case 'F':
                    case '여':
                        return "F";
                    case 'M':
                    case '남':
                        return "M";
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("여성인 경우 F, 남성인 경우 M을 적어주세요");
            }
        }

    }

}
