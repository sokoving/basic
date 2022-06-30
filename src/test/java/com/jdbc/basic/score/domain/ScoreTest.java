package com.jdbc.basic.score.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    @DisplayName("생성자로 score 객체를 만들고 getter setter tostring 메서드를 쓸 수 있다")
    void lombokTest(){

        Score s = new Score(1, "김철수", 10, 20, 30, 60 , 20);
        System.out.println(s.getStuName());
        System.out.println(s);
    }

    @Test
    @DisplayName("lombok이 제공하는 builder 기능으로 객체를 만든다")
    void lombokBuilderTest(){
        Score.ScoreBuilder choi = new Score.ScoreBuilder()
                .stuName("최승철")
                .stuNum(2)
                .math(30);
        System.out.println(choi);

    }

}