package com.jdbc.basic.trainee_record.controller;

import com.jdbc.basic.score.domain.Score;
import com.jdbc.basic.trainee_record.domain.Trainee;
import com.jdbc.basic.trainee_record.repository.TraineeOracleRepo;
import com.jdbc.basic.trainee_record.repository.TraineeRepository;

import java.util.*;

// 데이터들을 전처리, 후처리하고 저장 관리하는 클래스
public class TraineeController {

    // 학생 정보가 저장될 맵(K: 학생 아이디, V: Trainee)
    private static Map<Integer, Trainee> traineeMap;
    private final TraineeRepository repository;

    static {
        traineeMap = new HashMap<>();
    }

    public TraineeController(){
        this.repository = new TraineeOracleRepo();
    }

    // 새 수강생 등록 기능
    public boolean insertTrainee(Trainee trainee){
        try {
            traineeMap.put(trainee.getTrNum(), trainee);
            return repository.save(trainee);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 수강생 전체 정보 조회
    public List<Trainee> findAllTrainee(){
        // DB에서 받아온 수강생 맵을 저장
        Map<Integer, Trainee> traineeMap = repository.findAll();
        // 수강생 맵의 값만 수강생 배열에 저장
        List<Trainee> traineeList = new ArrayList<>();

        for (Integer trNum : traineeMap.keySet()) {
            traineeList.add(traineeMap.get(trNum));
        }
        return traineeList;
    }

    // 수강생 개별 정보 조회
    public Trainee findOneTrainee(int trNum){
        return repository.findOne(trNum);
    }

    // 수강생 정보 수정
    public boolean modifyTrainee(Trainee t){
        return repository.modifyInfo(t);
    }

    // 수강생 기록 갱신
    public boolean updateTrainee(Trainee t){
        return repository.updateRecord(t);
    }

    // 수강생 퇴원 처리(기록 삭제)
    public boolean deleteTrainee(int trNum){
        return repository.remove(trNum);
    }




}
