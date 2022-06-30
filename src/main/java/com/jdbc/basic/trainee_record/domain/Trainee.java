package com.jdbc.basic.trainee_record.domain;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
@Builder // 객체 생성시 생성자 역할을 대신한다

// 데이터베이스 trainee 테이블의 행데이터를 저장할 객체
public class Trainee {

    private int trNum; //학생 아이디
    private String trName; // 학생 이름
    private String trSex; // 학생 성별

    private double run100; // 100m 달리기 기록
    private int run1000;  // 1000m 달리기 기록
    private int sitUp; // 윗몸일으키기 기록
    private int pushUp;  // 팔굽혀펴기 기록
    private int rightGrip; // 오른손 악력 기록
    private int leftGrip; // 왼손 악력 기록


}
