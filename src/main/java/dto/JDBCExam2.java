package dto;

import dao.RoleDao;

public class JDBCExam2 {
    public static void main(String[] args) {
        int roleId = 500;
        String description = "CTO";

        Role role = new Role(roleId, description);
        RoleDao dao = new RoleDao();

        System.out.println(dao.addRole(role));

        // DB
        // mysql> SELECT role_id, description FROM noel.role WHERE role_id = 500;
        //+---------+-------------+
        //| role_id | description |
        //+---------+-------------+
        //|     500 | CTO         |
        //+---------+-------------+
    }
}
