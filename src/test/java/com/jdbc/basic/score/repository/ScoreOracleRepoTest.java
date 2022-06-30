package com.jdbc.basic.score.repository;

import com.jdbc.basic.score.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScoreOracleRepoTest {

    ScoreRepository repository = new ScoreOracleRepo();

    @Test
    @DisplayName("성적 정보를 DB에 삽입해야 한다")
    void saveTest(){

        Score kim = new Score();
        kim.setStuName("육번학생");
        kim.setKor(80);
        kim.setEng(70);
        kim.setMath(60);
        kim.calc();

        boolean result = repository.save(kim);
        assertTrue(result);
    }

    @Test
    @DisplayName("특정 성적 정보를 삭제해야 한다")
    void removeTest(){

        //given
        int stuNum = 4;
        //when
        boolean result = repository.remove(stuNum);
        //then
        Score score = repository.findOne(4);
        assertNull(score);
    }

    @Test
    @DisplayName("Score 객체를 전달하면 해당 Score 값으로 수정된다")
    void modifyTest(){

        Score modi = repository.findOne(4);
        modi.setStuName("낌톄쓰트");
        modi.setKor(1);
        modi.setMath(1);

        boolean result = repository.modify(modi);
        System.out.println(modi);
        assertTrue(result);
    }

    @Test
    @DisplayName("전체 성적 정보를 조회해야 한다.")
    void findAllTest() {

        Map<Integer, Score> scoreMap = repository.findAll();
        for (Integer stuNum : scoreMap.keySet()) {
            System.out.println(scoreMap.get(stuNum));
        }

        assertEquals(3, scoreMap.size());

    }

    @Test
    @DisplayName("개인 성적 정보를 조회해야 한다.")
    void findOneTest() {

        Score one = repository.findOne(3);

        System.out.println(one);
        assertEquals("박영희", one.getStuName());

    }


}