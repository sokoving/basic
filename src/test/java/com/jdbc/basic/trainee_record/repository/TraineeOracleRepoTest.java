package com.jdbc.basic.trainee_record.repository;

import com.jdbc.basic.trainee_record.domain.Trainee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TraineeOracleRepoTest {

    TraineeRepository repository = new TraineeOracleRepo();

    @Test
    @DisplayName("수강생 정보가 DB에 삽입된다")
    void saveTest(){
        Trainee t = new Trainee();
        t.setTrName("민니");
        t.setTrSex("M");
        t.setRun100(10);
        t.setRun1000(10);
        t.setPushUp(10);
        t.setSitUp(10);
        t.setRightGrip(10);
        t.setLeftGrip(10);

        boolean flag = repository.save(t);
        assertTrue(flag);

    }

    @Test
    @DisplayName("수강생 정보가 DB에서 삭제된다")
    void removeTest(){

        // 삭제 진행
        boolean flag = repository.remove(8);
        assertTrue(flag);

    }

    @Test
    @DisplayName("수강생 정보 하나를 DB에서 갖고 온다")
    void findOneTest(){
        Trainee one = repository.findOne(5);
        System.out.println(one);
        assertEquals(5, one.getTrNum());
    }

    @Test
    @DisplayName("수강생 전체 DB에서 갖고 온다")
    void findAllTest(){
        Map<Integer, Trainee> all = repository.findAll();
        Set<Integer> keys = all.keySet();
        for (Integer key : keys) {
            System.out.println(all.get(key));
        }
        assertEquals(6,  all.size());
    }

    @Test
    @DisplayName("수강생 기록을 갱신한다")
    void updateRecordTest(){
        Trainee one = repository.findOne(5);
        System.out.println(one);
        one.setRun100(20);
        one.setRun1000(20);
        one.setSitUp(20);
        one.setPushUp(20);
        one.setRightGrip(20);
        one.setLeftGrip(20);
        System.out.println(one);
        boolean flag = repository.updateRecord(one);
        assertTrue(flag);

    }

    @Test
    @DisplayName("수강생 개인정보를 수정한다")
    void modifyInfoTest(){
        Trainee one = repository.findOne(9);
        System.out.println(one);
        one.setTrName("니차 욘따라락");
        one.setTrSex("F");
        one.setSitUp(40);
        System.out.println(one);
        boolean flag = repository.modifyInfo(one);
        assertTrue(flag);

    }

}