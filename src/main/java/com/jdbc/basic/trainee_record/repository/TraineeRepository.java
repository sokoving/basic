package com.jdbc.basic.trainee_record.repository;

import com.jdbc.basic.trainee_record.domain.Trainee;

import java.util.Map;

// DB 연동을 담당하는 패키지의 성적 DB 인터페이스
public interface TraineeRepository {

    // 실제 정보 저장
    boolean save(Trainee trainee);

    // 실제 정보 삭제
    boolean remove(int trNum);

    // 기록 정보 수정
    boolean updateRecord(Trainee trainee);

    // 개인 정보 수정
    boolean modifyInfo(Trainee trainee);

    // 전체 기록 조회
    Map<Integer, Trainee> findAll();

    // 개별 기록 조회
    Trainee findOne(int trNum);




}
