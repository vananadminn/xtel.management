package com.xmedia.springstart.response.model;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.data_query_model.Employee.EmployeeSkillList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetListEmployeeSkill {
    public static List<EmployeeSkillList> GLES() throws Exception {
        String sql = "select distinct e.name as employeeName, e.email as email, s.name as skillName from employee e join skills_employees se on e.id = se.employees_id join skill s on s.id = se.skills_id";
        ResultSet rs = null;
        Connection con = null;
        List<EmployeeSkillList> listResponse = new ArrayList<>();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String status = null;
                EmployeeSkillList model = new EmployeeSkillList();
                model.setEmployeeName(rs.getString("employeeName"));
                model.setEmail(rs.getString("email"));
                model.setSkillName(rs.getString("skillName"));
                listResponse.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            rs.close();
        }
        return listResponse;
    }
}
