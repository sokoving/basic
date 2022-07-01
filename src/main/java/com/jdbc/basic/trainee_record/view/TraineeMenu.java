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
            System.out.println("====== 미래경찰 체력스쿨에 오신 것을 환영합니다 ======\n");
            System.out.println("# 1. 새 수강생 등록");
            System.out.println("# 2. 수강생 조회");
            System.out.println("# 3. 수강생 관리");
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
                    findOneMenu();
                    break;
                case 4:
                    modifyMode();
                    break;
                case 5:
                    updateMode();
                case 6:
                    removeMenu();
                    break;
                case 9:
                    System.out.println("\n# 프로그램을 종료합니다");
                    System.out.println("  빠잉~");
                    return;
                default:
                    System.out.println("# 메뉴 번호를 입력해 주세요. ");

            }
        }
    }

    // case 6 수강생 삭제
    private void removeMenu() {
        System.out.println("\n# 삭제할 수강생의 아이디를 입력해 주세요. ");
        int trNum = inputNum(" >> ");

        Trainee t = controller.findOneTrainee(trNum);
        if (t != null) {
            t.printInfo();
            System.out.println();
            System.out.printf("1. %s(%d) 님을 퇴원 처리합니다. \n", t.getTrName(), t.getTrNum());
            System.out.println("2. 이전 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    boolean flag = controller.deleteTrainee(trNum);

                    if (flag) {
                        System.out.println("퇴원 처리가 완료되었습니다. ");
                    } else {
                        System.out.println("퇴원 처리에 실패했습니다.");
                    }

                    return;
                case 2:
                    return;
                default:
                    System.out.println("# 메뉴 번호를 입력해 주세요. ");

            }


        } else {
            System.out.println("존재하지 않는 아이디입니다. ");
        }

    }

    // case 5 수강생 기록 갱신
    private void updateMode() {
        Trainee t = findOneMenu();
        if (t != null) {
            updateMenu(t);
        } else {
            System.out.println("메인메뉴로 돌아갑니다. ");
        }
    }

    private void updateMenu(Trainee t) {

        while (true) {
            System.out.println("1. 전체 기록 갱신");
            System.out.println("2. 개별 항목 갱신");
            System.out.println("9. 메인으로 돌아가기");

            int menu = inputNum("\n 메뉴 입력: ");

            switch (menu) {
                case 1:
                    updateAll(t);
                    return;
                case 2:
                    updateEach(t);
                    return;
                case 9:
                    System.out.println("# 메인으로 돌아갑니다");
                    return;
                default:
                    System.out.println("# 메뉴 번호를 입력해 주세요. ");
            }
        }
    }

    // 개별 기록 갱신하기
    private void updateEach(Trainee t) {
        while (true) {
            System.out.println("\n1. 100m 달리기");
            System.out.println("2. 1000m 달리기");
            System.out.println("3. 팔굽혀펴기");
            System.out.println("4. 윗몸일으키기");
            System.out.println("5. 오른손 악력");
            System.out.println("6. 왼손 악력");
            System.out.println("9. 메인으로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    double run100 = inputDouble("100m 달리기 : " + t.getRun100() + " >> ");
                    t.setRun100(run100);
                    break;
                case 2:
                    int run1000 = inputNum("1000m 달리기 : " + t.getRun1000() + " >> ");
                    t.setRun1000(run1000);
                    break;
                case 3:
                    int sitUp = inputNum("팔굽혀펴기 : " + t.getSitUp() + " >> ");
                    t.setSitUp(sitUp);
                    break;
                case 4:
                    int pushUp = inputNum("윗몸일으키기 : " + t.getPushUp() + " >> ");
                    t.setPushUp(pushUp);
                    break;
                case 5:
                    int rightGrip = inputNum("오른손 악력 : " + t.getRightGrip() + " >> ");
                    t.setRightGrip(rightGrip);
                    break;
                case 6:
                    int leftGrip = inputNum("왼손 악력 : " + t.getLeftGrip() + " >> ");
                    t.setLeftGrip(leftGrip);
                    break;
                case 9:
                    boolean flag = controller.updateTrainee(t);
                    return;
                default:
                    break;
            }

        }

    }

    // 모든 기록 갱신하기
    private void updateAll(Trainee t) {

        System.out.printf("# %s 님의 전체 기록을 갱신합니다", t.getTrName());
        double run100 = inputDouble("100m 달리기 : " + t.getRun100() + " >> ");
        t.setRun100(run100);
        int run1000 = inputNum("1000m 달리기 : " + t.getRun1000() + " >> ");
        t.setRun1000(run1000);
        int sitUp = inputNum("팔굽혀펴기 : " + t.getSitUp() + " >> ");
        t.setSitUp(sitUp);
        int pushUp = inputNum("윗몸일으키기 : " + t.getPushUp() + " >> ");
        t.setPushUp(pushUp);
        int rightGrip = inputNum("오른손 악력 : " + t.getRightGrip() + " >> ");
        t.setRightGrip(rightGrip);
        int leftGrip = inputNum("왼손 악력 : " + t.getLeftGrip() + " >> ");
        t.setLeftGrip(leftGrip);

        t.printInfo();

        while (true) {
            System.out.println("1. 갱신을 완료합니다. ");
            System.out.println("2. 갱신을 취소합니다. ");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    boolean flag = controller.updateTrainee(t);

                    if (flag) {
                        System.out.println("갱신이 완료되었습니다. ");
                    } else {
                        System.out.println("갱신에 실패하였습니다. ");
                    }
                    return;
                case 2:
                    System.out.println("갱신을 취소합니다. ");
                    return;
                default:
                    System.out.println("1 또는 2를 입력해 주세요");
            }
        }


    }

    // case 5 수강생 정보 수정
    private void modifyMode() {
        Trainee t = findOneMenu();
        if (t != null) {
            modifyMenu(t);
        } else {
            System.out.println("메인메뉴로 돌아갑니다. ");
        }
    }

    private void modifyMenu(Trainee t) {

        while (true) {
            System.out.println("# 수정할 항목을 선택해 주세요");
            System.out.println("1. 이름");
            System.out.println("2. 성별");
            System.out.println("9. 수정 종료");

            int menu = inputNum("\n 메뉴 입력: ");

            switch (menu) {
                case 1:
                    String name = inputStr(t.getTrName() + " >> ");
                    t.setTrName(name);
                    break;
                case 2:
                    String trSex = inputSex(t.getTrSex() + " >> ");
                    t.setTrSex(trSex);
                    break;
                case 9:
                    boolean flag = controller.modifyTrainee(t);

                    if (flag) {
                        System.out.printf("# 정보가 수정되었습니다 > %s(%s)\n", t.getTrName(), t.getTrSex());
                    } else {
                        System.out.println("# 정보 수정에 실패했습니다.");
                    }
                    return;
                default:
                    System.out.println("# 메뉴 번호를 입력해 주세요. ");
            }
        }

    }

    // case 3 수강생 개별 조회
    private Trainee findOneMenu() {

        System.out.println("# 수강생 아이디를 입력하세요");
        int trNum = inputNum(" >> ");
        Trainee t = controller.findOneTrainee(trNum);
        if (t != null) {
            t.printInfo();
            System.out.println();
        } else {
            System.out.println("존재하지 않는 아이디입니다. ");
        }

        return t;


    }

    // case 2 수강생 전체 조회
    private void findAllMenu() {
        List<Trainee> traineeList = controller.findAllTrainee();
        System.out.println("\n==================== 전체 수강생 정보 ====================");
        Trainee.printMenu();
        for (Trainee t : traineeList) {
            System.out.println(t);
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

        if (flag) {
            System.out.printf("\n# [ %s ] 님의 정보가 등록되었습니다\n.", name);
        } else {
            System.out.println("# 회원 등록에 실패했습니다. ");
        }
    }

    //================ 입력기 ==================//


    // 메세지 출력과 숫자 입력을 동시에
    private int inputNum(String msg) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                if (n <= 0) {
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
