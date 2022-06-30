package com.jdbc.basic.score.controller;

import com.jdbc.basic.score.domain.Score;
import com.jdbc.basic.score.repository.ScoreOracleRepo;
import com.jdbc.basic.score.repository.ScoreRepository;

import java.util.*;

// 데이터들을 전처리, 후처리하고 저장 관리하는 클래스
public class ScoreController {

    // 성적 정보가 저장될 맵(k: 학번, v: 성적 정보)
        // 배열이나 리스트를 쓰면 데이터가 중간 삭제, 수정될 시 학생의 인덱스가 변화됨으로
        // 학생의 키를 고정할 수 있는 맵을 사용
    private static Map<Integer, Score> scoreMap;

    // ScoreRepository에 의존성 관계를 가진다
    // 의존하는 클래스는 추상 클래스나 인터페이스(다형성)
    private final ScoreRepository repository;

    public ScoreController() {
        this.repository = new ScoreOracleRepo();
    }

    static {
        scoreMap = new HashMap<>();
    }


    // 학생 성적정보 입력 기능
    public void insertStudent(Score score) {
        // 메모리에 저장
        scoreMap.put(score.getStuNum(), score);
        // DB에 저장 명령
        repository.save(score);
    }

    // 학생 전체 정보 조회
    public List<Score> findAllStudents(){
        Map<Integer, Score> students = repository.findAll();
        scoreMap = students;

        List<Score> scoreList = new ArrayList<>();
        for (Integer stuNum : scoreMap.keySet()) {
            scoreList.add(scoreMap.get(stuNum));
        }
        return scoreList;
    }

    // 반 평균을 구하는 메서드
    public double calcClassAverage() {
        // case 1: 앱 내부에서 구한다. > 데이터가 많아지면 과부화
        /*double avgSum = 0.0;
        for (Integer stuNum : scoreMap.keySet()) {
            avgSum += scoreMap.get(stuNum).getAverage();
        }
        return avgSum / scoreMap.size();*/

        // case 2: DB에서 전체평균을 구해서 가져온다.
        return repository.getClassAverage();
    }

    // 성적 개별 조회
    public Score findOneStudent(int stuNum) {
        return repository.findOne(stuNum);
    }

    // 성적 수정
    public boolean updateStudent(int stuNum, int kor, int eng, int math) {
        // 1. DB에서 해당 학생을 조회한다.
        Score target = findOneStudent(stuNum);

        if (target != null) {
            // 2. 수정 진행
            target.setKor(kor);
            target.setEng(eng);
            target.setMath(math);
            target.calc();

            // 3. DB에 수정 반영
            return repository.modify(target);
        }
        return false;
    }

    // 성적정보 삭제
    public boolean deleteStudent(int stuNum) {
        return repository.remove(stuNum);
    }

    // 있는 학번인지 확인
    public boolean hasScore(int stuNum){
        Score flag = repository.findOne(stuNum);
        if (flag != null) {
            return true;
        } else {
            return false;
        }

    }

}
