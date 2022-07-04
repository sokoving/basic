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
            System.out.println("\n====== 오늘의 나는 어제의 나보다 1.1배 더 강하다 ======");
            System.out.println("====== 미래경찰 피지컬센터 회원관리 프로그램입니다 ======");

            System.out.println("\n1. 새 수강생 등록");
            System.out.println("2. 수강생 조회");
            System.out.println("3. 수강생 관리");
            System.out.println("9. 끝내기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    insertMenu();
                    break;
                case 2:
                    findMenu();
                    break;
                case 3:
                    manageMenu();
                    break;

                case 9:
                    System.out.println("\n# 프로그램을 종료합니다");
                    System.out.println("  빠잉~");
                    return;
                default:
                    System.out.println("- 메뉴 번호를 입력해 주세요. ");

            }
        }
    }


    //----------------- case 3 수강생 관리 -----------------//
    private void manageMenu() {
        while (true) {
            System.out.println("\n1. 수강생 기록 관리");
            System.out.println("2. 수강생 개인정보 수정");
            System.out.println("3. 수강생 퇴원 처리");
            System.out.println("9. 이전 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    Trainee t = findOneMenu();
                    if (t == null) break;
                    updateMenu(t);
                    break;
                case 2:
                    modifyMenu();
                    break;
                case 3:
                    removeMenu();
                    break;
                case 9:
                    System.out.println("- 이전 메뉴로 돌아갑니다. ");
                    return;
                default:
                    System.out.println("- 메뉴 번호를 입력해 주세요. ");
            }
        }
    }

    // case 3-3 수강생 퇴원 처리
    private void removeMenu() {

        Trainee t = findOneMenu();
        if (t == null) return;

        System.out.printf("\n1. %s(%d) 님을 퇴원 처리합니다. \n", t.getTrName(), t.getTrNum());
        System.out.println("2. 이전 메뉴로 돌아가기");

        int menu = inputNum(" >> ");

        switch (menu) {
            case 1:
                boolean flag = controller.deleteTrainee(t.getTrNum());

                if (flag) {
                    System.out.println("퇴원 처리가 완료되었습니다. ");
                } else {
                    System.out.println("퇴원 처리에 실패했습니다.");
                }
                return;
            case 2:
                System.out.println("- 이전 메뉴로 돌아갑니다. ");
                return;
            default:
                System.out.println("- 메뉴 번호를 입력해 주세요. ");

        }

    }


    // case 3-2 수강생 개인정보 수정
    private void modifyMenu() {

        // 9. 수정 종료 시 분기점
        boolean flag = false;

        Trainee t = findOneMenu();
        if (t == null) return;

        while (true) {
            System.out.println("\n# 수정할 항목을 선택해 주세요");
            System.out.println("1. 이름");
            System.out.println("2. 성별");
            System.out.println("9. 이전 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    String name = inputStr(t.getTrName() + " >> ");
                    t.setTrName(name);
                    flag = true;
                    break;
                case 2:
                    String trSex = inputSex(t.getTrSex() + " >> ");
                    t.setTrSex(trSex);
                    flag = true;
                    break;
                case 9:
                    if(flag) {
                        boolean result = controller.modifyTrainee(t);

                        if (result) {
                            System.out.printf("- 정보가 수정되었습니다 > %s(%s)\n", t.getTrName(), t.getTrSex());
                        } else {
                            System.out.println("- 정보 수정에 실패했습니다.");
                        }
                    }
                    System.out.println("- 이전 메뉴로 돌아갑니다. ");
                    return;
                default:
                    System.out.println("- 메뉴 번호를 입력해 주세요. ");
            }
        }

    }


    // case 3-1 수강생 기록 관리
    private void updateMenu(Trainee t) {

        while (true) {
            System.out.println("\n1. 전체 기록 갱신");
            System.out.println("2. 개별 항목 갱신");
            System.out.println("9. 이전 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    updateAll(t);
                    break;
                case 2:
                    updateEach(t);
                    break;
                case 9:
                    System.out.println("- 이전 메뉴로 돌아갑니다");
                    return;
                default:
                    System.out.println("- 메뉴 번호를 입력해 주세요. ");
            }
        }
    }


    // caes 3-1-2 개별 기록 갱신하기
    private void updateEach(Trainee t) {
        boolean flag = false;
        while (true) {
            System.out.println("\n1. 100m 달리기");
            System.out.println("2. 1000m 달리기");
            System.out.println("3. 팔굽혀펴기");
            System.out.println("4. 윗몸일으키기");
            System.out.println("5. 오른손 악력");
            System.out.println("6. 왼손 악력");
            System.out.println("9. 이전 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    double run100 = inputDouble("100m 달리기 : " + t.getRun100() + " >> ", 50);
                    t.setRun100(run100);
                    flag = true;
                    break;
                case 2:
                    int run1000 = inputNum("1000m 달리기 : " + t.getRun1000() + " >> ", 500);
                    t.setRun1000(run1000);
                    flag = true;
                    break;
                case 3:
                    int sitUp = inputNum("팔굽혀펴기 : " + t.getSitUp() + " >> ", 100);
                    t.setSitUp(sitUp);
                    flag = true;
                    break;
                case 4:
                    int pushUp = inputNum("윗몸일으키기 : " + t.getPushUp() + " >> ", 100);
                    t.setPushUp(pushUp);
                    flag = true;
                    break;
                case 5:
                    int rightGrip = inputNum("오른손 악력 : " + t.getRightGrip() + " >> ", 100);
                    t.setRightGrip(rightGrip);
                    flag = true;
                    break;
                case 6:
                    int leftGrip = inputNum("왼손 악력 : " + t.getLeftGrip() + " >> ", 100);
                    t.setLeftGrip(leftGrip);
                    flag = true;
                    break;
                case 9:
                    if (flag) {
                        boolean result = controller.updateTrainee(t);

                        if (result) {
                            System.out.println("- 갱신이 완료되었습니다. ");
                        } else {
                            System.out.println("- 갱신에 실패하였습니다. ");
                        }
                    }
                    System.out.println("- 이전 메뉴로 돌아갑니다. ");
                    return;
                default:
                    break;
            }

        }

    }


    // caes 3-1-1 전체 기록 갱신하기
    private void updateAll(Trainee t) {

        System.out.printf("\n# %s 님의 전체 기록을 갱신합니다. \n", t.getTrName());
        double run100 = inputDouble("100m 달리기 : " + t.getRun100() + " >> ", 50);
        int run1000 = inputNum("1000m 달리기 : " + t.getRun1000() + " >> ", 500);
        int sitUp = inputNum("팔굽혀펴기 : " + t.getSitUp() + " >> ", 100);
        int pushUp = inputNum("윗몸일으키기 : " + t.getPushUp() + " >> ", 100);
        int rightGrip = inputNum("오른손 악력 : " + t.getRightGrip() + " >> ", 100);
        int leftGrip = inputNum("왼손 악력 : " + t.getLeftGrip() + " >> ", 100);

        while (true) {
            System.out.println("\n1. 갱신을 완료합니다. ");
            System.out.println("2. 갱신을 취소합니다. ");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    t.setRun100(run100);
                    t.setRun1000(run1000);
                    t.setSitUp(sitUp);
                    t.setPushUp(pushUp);
                    t.setRightGrip(rightGrip);
                    t.setLeftGrip(leftGrip);

                    boolean flag = controller.updateTrainee(t);

                    if (flag) {
                        System.out.println("- 갱신이 완료되었습니다. ");
                    } else {
                        System.out.println("- 갱신에 실패하였습니다. ");
                    }
                    return;
                case 2:
                    System.out.println("- 갱신을 취소합니다. ");
                    return;
                default:
                    System.out.println("- 1 또는 2를 입력해 주세요");
            }
        }


    }


    //----------------- case 2 수강생 조회 -----------------//
    private void findMenu() {
        while (true) {
            findAllMenu();
            System.out.println("\n1. 수강생 관리 메뉴로 가기");
            System.out.println("2. 이전 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    manageMenu();
                    return;
                case 2:
                    System.out.println("\n- 이전 메뉴로 돌아갑니다. ");
                    return;
                default:
                    System.out.println("- 1 또는 2를 입력해 주세요");
            }
        }
    }

    // 수강생 개별 조회(찾으면 Trainee 정보를 출력하고 리턴, 못 찾으면 못 찾았다 출력하고 null 리턴)
    private Trainee findOneMenu() {

        int trNum;
        while (true) {
            System.out.println("\n# 수강생 아이디를 입력하세요. (0을 입력하면 전체 수강생이 조회됩니다)");
            trNum = inputNum(" >> ");
            System.out.println();

            if(trNum == 0) {
                findAllMenu();
                System.out.println();
            } else {
                break;
            }
        }
        Trainee t = controller.findOneTrainee(trNum);

        if (t != null) {
            t.printInfo();
        } else {
            System.out.println("- 존재하지 않는 아이디입니다. ");
        }
        return t;

    }

    // 수강생 전체 조회
    private void findAllMenu() {
        List<Trainee> traineeList = controller.findAllTrainee();
        for (int i = 0; i < traineeList.size(); i++) {
            if (i % 5 == 0) {
                System.out.printf("\n=================== 전체 수강생 정보(%d/%d) ===================\n", (i / 5) + 1, (traineeList.size() / 5) + 1);
                Trainee.printMenu();
            }
            System.out.println(traineeList.get(i));
        }

    }

    //----------------- case 1. 새 수강생 등록 -----------------------//
    private void insertMenu() {

        while (true) {
            System.out.println("\n# 새 수강생을 등록합니다.");
            String name = inputStr("- 이름 : ");
            String sex = inputSex("- 성별(M/F) : ");

            System.out.println("\n# 체력 시험 결과를 입력해 주세요");
            double run100 = inputDouble("- 100m 달리기(초) : ", 50);
            int run1000 = inputNum("- 1000m 달리기(초) : ", 500);
            int situp = inputNum("- 윗몸일으키기(회/1분) : ", 100);
            int pushup = inputNum("- 팔굽혀펴기(회/1분) : ", 100);
            int rightGrip = inputNum("- 오른손 악력(kg) : ", 100);
            int leftGrip = inputNum("- 왼손 악력(kg) : ", 100);

            Trainee newT = new Trainee();
            newT.setTrName(name);
            newT.setTrSex(sex);
            newT.setRun100(run100);
            newT.setRun1000(run1000);
            newT.setSitUp(situp);
            newT.setPushUp(pushup);
            newT.setRightGrip(rightGrip);
            newT.setLeftGrip(leftGrip);

            System.out.println();
            newT.printInfo();

            System.out.printf("\n1. %s 님의 정보 등록하기 \n", name);
            System.out.println("2. 다시 작성하기");
            System.out.println("9. 메인 메뉴로 돌아가기");

            int menu = inputNum(" >> ");

            switch (menu) {
                case 1:
                    boolean flag = controller.insertTrainee(newT);
                    if (flag) {
                        System.out.printf("\n- %s 님이 등록되었습니다.\n", name);
                    } else {
                        System.out.println("\n- 회원 등록에 실패했습니다. ");
                    }
                    return;
                case 2:
                    break;
                case 9:
                    System.out.println("- 메인 메뉴로 돌아갑니다. ");
                    return;
                default:
                    System.out.println("- 메뉴 번호를 입력해 주세요. ");

            }
        }


    }

    //================ 입력기 ==================//


    // 메세지 출력과 숫자 입력을 동시에
    private int inputNum(String msg, int max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                if (n <= 0 || n > max) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.printf("- 0~%d 범위 안의 정수를 입력해 주세요. \n", max);
                System.out.println();
            }
        }
        return n;
    }

    private int inputNum(String msg) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("- 숫자를 입력해 주세요.");
                System.out.println();
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

                if (s.length() < 2 || s.length() > 5) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("- 글자수 2~5자 내에서 입력해 주세요. ");
                System.out.println();
            }
        }
        return s;
    }

    // 메세지 출력과 실수 입력을 동시에
    private double inputDouble(String msg, int max) {
        double d;
        while (true) {
            try {
                System.out.print(msg);
                d = sc.nextDouble();
                if (d <= 0 || d > max) {
                    throw new Exception();
                } else {
                    d = (double) Math.round(d * 10) / 10;
                    break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.printf("- 0~%d 범위 안의 수를 입력해 주세요. \n", max);
                System.out.println();
            }
        }
        return d;
    }

    // 찰떡같은 성별 입력받기
    private String inputSex(String msg) {
        while (true) {
            try {
                System.out.print(msg);
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
                System.out.println("- 여성인 경우 F, 남성인 경우 M을 적어주세요");
                System.out.println();
            }
        }

    }

}
