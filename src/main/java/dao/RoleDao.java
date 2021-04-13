package dao;

import dto.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/noel";
    private static final String dbUser = "noel";
    private static final String dbPassword = "1234";


    public int update(int roleId, String toDescription) {
        int updateCount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "UPDATE role SET description = ? WHERE role_id = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, toDescription);
            ps.setInt(2, roleId);

            updateCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateCount;
    }

    public int delete(int role_id) {

        int deleteCount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "DELETE FROM role WHERE role_id = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, role_id);

            deleteCount = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleteCount;

    }

    public List<Role> getRoles() {
        List<Role> roleList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT role_id, description FROM role ORDER BY role_id DESC"; // DESC : 내림차순
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("role_id");
                    String desc = rs.getString("description");

                    roleList.add(new Role(id, desc));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roleList;

    }


    public int addRole(Role role) { // INSERT 실습
        int insertCount = 0; // SQL문 실행했을 때 '몇 건' 실행했습니다에서 카운트를 담을 변수

        Connection conn = null;
        PreparedStatement ps = null;
        // INSERT문이기 때문에 ResultSet은 불필요

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getDescription());

            insertCount = ps.executeUpdate(); // SELECT와 다름

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return insertCount;
    }

    public Role getRole(Integer roleId) { // SELECT 실습
        Role role = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "SELECT role_id, description FROM noel.role WHERE role_id = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roleId); // ? 의 순서를 말함 첫번째 물음표

            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    // 컬럼 인덱스 : SELECT 선택한 요소에 따라
                    String description = rs.getString(2);
                    int id = rs.getInt("role_id");

                    role = new Role(id, description);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }
}
