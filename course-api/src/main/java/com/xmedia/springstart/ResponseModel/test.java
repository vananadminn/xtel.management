package com.xmedia.springstart.ResponseModel;


import com.google.gson.Gson;
import com.ligerdev.appbase.utils.db.BaseDAO;
import com.ligerdev.appbase.utils.db.GenDbSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        GenDbSource.genDTO("main", "SkillEmployee", "select id, employees_id, skills_id, created_date, created_by from skills_employees;", "id", "");
        BaseDAO baseDAO = BaseDAO.getInstance("main");
        String name = "'Java core'";
        //sql ="select * from (select `e`.`name` name , `e`.`email` email, `s`.`name` skillName, `ex`.`start` start, `ex`.`now` now FROM `employee` e join `employee_experience` ee on `e`.`id` = `ee`.`employee_id` join `experience` ex on `ex`.`id` = `ee`.`experience_id` join `skill` s on `s`.`id` = `ee`.`skills_id` where `s`.`name` =" +name+" )a";
//        System.out.println(sql);


//        try {
//            list = baseDAO.getListBySql("sad",SeResponse.class,sql,null,null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        System.out.println(sql);


    }

//    public SeResponse getSkillEmployeeByName(String name) throws SQLException {
//        String sql = "select * from (select e.name as name , e.email as email, s.name as skillName, bx.start as start, bx.now as now FROM employee e join employee_experience ee on e.id = ee.employee_id join experience bx on bx.id = ee.experience_id join skill s on s.id = ee.skills_id where s.name =" + name + " )a";
//        ResultSet rs = null;
//        Connection conn = null;
//        ArrayList<SeResponse> list = new ArrayList<SeResponse>();
//        SeResponse seResponse = new SeResponse();
//
//        try {
//            conn = BaseDAO.getInstance("main").getConnection();
//            rs = conn.prepareStatement(sql).executeQuery();
//            while (rs.next()) {
//                seResponse.setName(rs.getString("name"));
//                seResponse.setEmail(rs.getString("email"));
//                seResponse.setSkillName(rs.getString("skillName"));
//                seResponse.setStart(rs.getDate("start"));
//                seResponse.setNow(rs.getDate("now"));
//                list.add(seResponse);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conn.close();
//            rs.close();
//        }
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        return seResponse;
//    }
}
