package com.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;

// Oracle DB 연결
public class Connect {
    // 데이터 베이스 연결을 위한 정보 저장
    private final static String ACCOUNT = "sqld"; // 계정명
    private final static String PASSWORD = "1234"; // 비밀번호
    // 데이터베이스의 위치 정보(DB URL) - DB 회사마다 패턴이 다름
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    // @localhost : 내 아이피 주소(=125.133.75.24)를 자동으로 찾아서 연결함 (db가 있는 위치를 적으면 됨)
    // 데이터베이스 접속에 쓸 드라이버 클래스 = DB 회사마다 다름
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    // oracle jdbc driver class name 검색

    // DB 연결 메서드
    public static Connection makeConnection() {

        try {
            // 1. 드라이버 클래스를 동적 로딩
            Class.forName(DRIVER);

            // 2. 연결정보를 담아 연결 객체를 생성
            Connection conn = DriverManager.getConnection(URL, ACCOUNT, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
