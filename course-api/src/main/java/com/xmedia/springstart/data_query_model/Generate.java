package com.xmedia.springstart.data_query_model;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.ligerdev.appbase.utils.db.GenDbSource;

public class Generate {
    public static void main(String[] args) {
        GenDbSource.genDTO("main", "EmployeeProcessListResponse", "select distinct e.id as employeeId, e.name as employeeName, e.email as employeeEmail, e.phone as employeePhone, s.name as skillEmployee,\n" +
                "po.name as positionName, pro.name as project, e.start_date as start, e.employee_date as 'to', e.status as statusEmployee from employee e\n" +
                "join skills_employees se on e.id = se.employees_id\n" +
                "join skill s on s.id = se.skills_id \n" +
                "join employee_position epo on e.id = epo.employee_id\n" +
                "join position po on po.id = epo.position_id \n" +
                "join project_employee proemp on e.id = proemp.employee_id\n" +
                "join project pro on pro.id = proemp.project_id\n" +
                ";" +
                ";", "", "");
        BaseDAO baseDAO = BaseDAO.getInstance("main");
//        String name = "'Java core'";
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
