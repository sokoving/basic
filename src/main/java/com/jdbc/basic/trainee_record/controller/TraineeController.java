package com.jdbc.basic.trainee_record.controller;

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







}
