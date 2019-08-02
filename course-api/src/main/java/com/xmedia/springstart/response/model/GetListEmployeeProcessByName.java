package com.xmedia.springstart.response.model;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.data_query_model.Employee.EmployeeProcessList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetListEmployeeProcessByName {

    private static String employeeStatus;
    private static String employeeName;

    public static List<EmployeeProcessList> GLEP(String employeeName) throws Exception {
        String sql = "select distinct e.id as employeeId, e.name as employeeName, e.email as employeeEmail, e.phone as employeePhone, s.name as employeeSkill,\n" +
                "po.name as positionName, pro.name as employeeProject, e.start_date as employeeStart, e.employee_date as employeeTo, e.status as employeeStatus from employee e\n" +
                "join skills_employees se on e.id = se.employees_id\n" +
                "join skill s on s.id = se.skills_id \n" +
                "join employee_position epo on e.id = epo.employee_id\n" +
                "join position po on po.id = epo.position_id \n" +
                "join project_employee proemp on e.id = proemp.employee_id\n" +
                "join project pro on pro.id = proemp.project_id\n WHERE e.name = " + "'" + employeeName + "'" +
                ";";
        ResultSet rs = null;
        Connection con = null;
        List<EmployeeProcessList> employeeProcesses = new ArrayList<>();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                EmployeeProcessList model = new EmployeeProcessList();
                model.setEmployeeId(rs.getInt("employeeId"));
                model.setEmployeeName(rs.getString("employeeName"));
                model.setEmployeeEmail(rs.getString("employeeEmail"));
                model.setEmployeePhone(rs.getString("employeePhone"));
                model.setSkillEmployee(rs.getString("employeeSkill"));
                model.setPositionName(rs.getString("positionName"));
                model.setProject(rs.getString("employeeProject"));
                model.setStart(rs.getDate("employeeStart"));
                model.setTo(rs.getDate("employeeTo"));
                if (rs.getBoolean("employeeStatus") == false) {
                    employeeStatus = "Đã nghỉ";
                } else {
                    employeeStatus = "Đang làm việc";
                }
                model.setEmployeeStatus(employeeStatus);
                employeeProcesses.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            rs.close();
        }
        return employeeProcesses;
    }

}
