package com.jdbc.basic.trainee_record.controller;

import com.jdbc.basic.trainee_record.domain.Trainee;

import java.util.*;

// 데이터들을 전처리, 후처리하고 저장 관리하는 클래스
public class TraineeController {

    // 학생 정보가 저장될 맵(K: 학생 아이디, V: Trainee)
    private static Map<Integer, Trainee> traineeMap;

    static {
        traineeMap = new HashMap<>();
    }


}
