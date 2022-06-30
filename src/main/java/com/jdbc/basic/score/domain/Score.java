package com.jdbc.basic.score.domain;

import lombok.*;

// 롬복 사용하기 : 커스텀은 직접 써서 해야 함
@Setter @Getter @ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
@Builder // 객체 생성시 생성자 역할을 대신한다

//@Data // 롬복이 제공하는 모든 기능을 한번에 만든다, 스택오버플로 날 수 있으니 쓰지 말 것

// 데이터베이스 score 테이블의 행데이터를 저장할 객체
public class Score {

    // sql > 스네이크케이스(대소문자 구분이 없기 때문에) / java > 캐멀케이스
    private int stuNum;
    private String stuName;
    private int kor;
    private int eng;
    private int math;
    private int total;
    private double average;

    // 총점, 평균을 계산하는 메서드
    public void calc(){
        this.total = kor + eng + math;
        this.average = Math.round(total / 3.0);
    }




}
