package com.jdbc.basic.score.repository;

import com.jdbc.basic.score.domain.Score;

import java.util.Map;

// DB 연동을 담당하는 패키지의 성적 DB 인터페이스
public interface ScoreRepository {

    // 실제 정보 저장
    boolean save(Score score);

    // 실제 정보 삭제
    boolean remove(int stuNum);

    // 성적 정보 수정
    boolean modify(Score score);

    // 전체 성적 조회
    Map<Integer, Score> findAll();

    // 개별 성적 조회
    Score findOne(int stuNum);

    // 반 학생 전체 평균 조회
    double getClassAverage();

}
