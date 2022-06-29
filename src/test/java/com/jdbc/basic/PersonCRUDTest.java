package com.jdbc.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jdbc.basic.PersonCRUD.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonCRUDTest {

    @Test
    @DisplayName("사람 정보가 데이터베이스에 저장되어야 한다")
    void saveTest(){

        // 사람 객체 생성
        Person p = makePerson("000629-1234568", "ㅇㅇ", 31);


        // 사람 저장 명령
        boolean result = save(p);

        // 단언
        assertTrue(result);

    }

    @Test
    @DisplayName("주어진 주민번호에 맞는 사람 정보를 데이터베이스에서 삭제해야 한다")
    void removeTest(){

        boolean result = remove("000629-1234568");

        assertTrue(result);

    }

    @Test
    @DisplayName("주어진 주민번호에 맞는 사람의 이름을 주어진 이름으로 수정해야 한다")
    void modifyTest(){

        boolean result = modify("000629-1234567", "1234");

        assertTrue(result);

    }


    @Test
    void bulkInsertTest() {

        String[] firstNames = {"김", "이", "박", "최", "송", "라"};
        for (int i = 0; i < 10; i++) {
            String f = firstNames[(int) (Math.random() * firstNames.length)];
            save(makePerson("991112-123456"+i, f+"철수", 24));
        }
    }


    @Test
    void findAllTest() {

        List<Person> all = findAll();

        for (Person person : all) {
            System.out.println(person);
        }

    }



}