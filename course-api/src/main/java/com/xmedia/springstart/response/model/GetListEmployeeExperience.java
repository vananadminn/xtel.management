package com.xmedia.springstart.response.model;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.data_query_model.SkillEmployeeListExperienceModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetListEmployeeExperience {
    public static List<SkillEmployeeListExperienceModel> GLEE() throws Exception {
        String sql = "SELECT DISTINCT e.name as employeeName, e.email, e.status, s.name as skillName, s.description, se.skill_start, se.skill_end from employee e join skills_employees se on e.id = se.employees_id join skill s on s.id = se.skills_id";
        ResultSet rs = null;
        Connection con = null;
        List<SkillEmployeeListExperienceModel> listResponse = new ArrayList<>();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                SkillEmployeeListExperienceModel model = new SkillEmployeeListExperienceModel();
                String status = null;
                model.setEmployeeName(rs.getString("employeeName"));
                model.setEmail(rs.getString("email"));
                model.setStatus(status);
                model.setSkillName(rs.getString("skillName"));
                model.setDescription(rs.getString("description"));
                model.setSkillStart(rs.getDate("skill_start"));
                model.setSkillEnd(rs.getDate("skill_end"));
                if (rs.getBoolean("status") == true) {
                    status = "Đang làm việc";
                } else if (rs.getBoolean("status") == false) {
                    status = "Đã nghỉ";
                }
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
