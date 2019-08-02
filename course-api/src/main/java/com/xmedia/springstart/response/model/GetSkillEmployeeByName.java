package com.xmedia.springstart.response.model;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.data_query_model.SeResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GetSkillEmployeeByName {
    public static SeResponse GSEBN(String name) throws SQLException {
        String sql = "select * from (select s.id, e.name as name , e.email as email, s.name as skillName, bx.start as start, bx.now as now FROM employee e join employee_experience ee on e.id = ee.employee_id join experience bx on bx.id = ee.experience_id join skill s on s.id = ee.skills_id where s.name ='" + name + "' )a";
        ResultSet rs = null;
        Connection con = null;
        ArrayList<SeResponse> list = new ArrayList<SeResponse>();
        SeResponse seResponse = new SeResponse();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Date date = new Date();
                seResponse.setId(rs.getInt("id"));
                seResponse.setName(rs.getString("name"));
                seResponse.setEmail(rs.getString("email"));
                seResponse.setSkillName(rs.getString("skillName"));
                seResponse.setStart(rs.getDate("start"));
                seResponse.setNow(date);
                list.add(seResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            rs.close();
        }
        return seResponse;
    }
}
