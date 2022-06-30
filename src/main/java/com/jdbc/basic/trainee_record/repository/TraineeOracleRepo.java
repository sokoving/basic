package com.jdbc.basic.trainee_record.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.trainee_record.domain.Trainee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Oracle DBMS에 수강생 정보를 CRUD하는 클래스
public class TraineeOracleRepo implements TraineeRepository {

    @Override
    public boolean save(Trainee trainee) {
        String sql = "INSERT INTO trainee " +
                "(tr_num, tr_name, tr_sex, run100, run1000, situp, pushup, rightgrip, leftgrip)" +
                " VALUES (seq_trainee.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = Connect.makeConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trainee.getTrName());
            pstmt.setString(2, trainee.getTrSex());
            pstmt.setDouble(3, trainee.getRun100());
            pstmt.setInt(4, trainee.getRun1000());
            pstmt.setInt(5, trainee.getSitUp());
            pstmt.setInt(6, trainee.getPushUp());
            pstmt.setInt(7, trainee.getRightGrip());
            pstmt.setInt(8, trainee.getLeftGrip());

            int result = pstmt.executeUpdate();

            if (result != 0){
                conn.commit(); // 커밋 완료
                return true;
            } else {
                conn.rollback(); // 롤백
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int trNum) {
        String sql = "DELETE FROM trainee WHERE tr_num=?";

        try(Connection conn = Connect.makeConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, trNum);

            int result = pstmt.executeUpdate();

            if (result != 0) {
                conn.commit(); // 커밋 완료
                return true;
            } else {
                conn.rollback(); // 롤백
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateRecord(Trainee trainee) {
        String sql = "UPDATE trainee " +
                "SET run100 = ?, run1000 = ?, situp = ?, pushup = ?, rightgrip = ?, leftgrip = ? " +
                "WHERE tr_num = ?";

        try(Connection conn = Connect.makeConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, trainee.getRun100());
            pstmt.setInt(2, trainee.getRun1000());
            pstmt.setInt(3, trainee.getSitUp());
            pstmt.setInt(4, trainee.getPushUp());
            pstmt.setInt(5, trainee.getRightGrip());
            pstmt.setInt(6, trainee.getLeftGrip());
            pstmt.setInt(7, trainee.getTrNum());

            int result = pstmt.executeUpdate();

            if (result != 0) {
                conn.commit(); // 커밋 완료
                return true;
            } else {
                conn.rollback(); // 롤백
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyInfo(Trainee trainee) {
        String sql = "UPDATE trainee " +
                "SET tr_name = ?, tr_sex = ?" +
                "WHERE tr_num = ?";

        try(Connection conn = Connect.makeConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trainee.getTrName());
            pstmt.setString(2, trainee.getTrSex());
            pstmt.setInt(3, trainee.getTrNum());

            int result = pstmt.executeUpdate();

            if (result != 0) {
                conn.commit(); // 커밋 완료
                return true;
            } else {
                conn.rollback(); // 롤백
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Map<Integer, Trainee> findAll() {
        Map<Integer, Trainee> traineeMap = new HashMap<>();

        String sql = "SELECT * FROM trainee ORDER BY tr_num";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Trainee t = new Trainee(
                        rs.getInt("tr_num")
                        , rs.getString("tr_name")
                        , rs.getString("tr_sex")
                        , rs.getDouble("run100")
                        , rs.getInt("run1000")
                        , rs.getInt("situp")
                        , rs.getInt("pushup")
                        , rs.getInt("rightgrip")
                        , rs.getInt("leftgrip")
                );
                traineeMap.put(t.getTrNum(), t);
            }
            return traineeMap;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    @Override
    public Trainee findOne(int trNum) {

        String sql = "SELECT * FROM trainee WHERE tr_num = ?";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, trNum);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Trainee t = new Trainee(
                        rs.getInt("tr_num")
                        , rs.getString("tr_name")
                        , rs.getString("tr_sex")
                        , rs.getDouble("run100")
                        , rs.getInt("run1000")
                        , rs.getInt("situp")
                        , rs.getInt("pushup")
                        , rs.getInt("rightgrip")
                        , rs.getInt("leftgrip")
                );
                return t;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
