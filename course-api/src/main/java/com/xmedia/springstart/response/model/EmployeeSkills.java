package com.xmedia.springstart.response.model;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.data_query_model.Employee.EmployeeSkill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSkills {
    /*this's function return result are: employee name, employee email, skill name if exists params is employee name*/
    public static List<EmployeeSkill> ES(String employeeName) throws Exception {
        String sql = "select e.name as employeeName, e.email as employeeEmail, s.name as skillName from employee e join skills_employees se on e.id = se.employees_id join skill s on s.id = se.skills_id where e.name =" + "'" + employeeName + "'";
        ResultSet rs = null;
        Connection con = null;
        List<EmployeeSkill> list = new ArrayList<>();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                EmployeeSkill model = new EmployeeSkill();
                model.setEmployeeName(rs.getString("employeeName"));
                model.setEmail(rs.getString("employeeEmail"));
                model.setSkillName(rs.getString("skillName"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            rs.close();
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        String employeeName = "Bui Van An";
        System.out.println(ES(employeeName));
    }
}
