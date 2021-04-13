package dao;

import dto.Role;

import java.sql.*;

public class RoleDao {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/noel";
    private static final String dbUser = "noel";
    private static final String dbPassword = "1234";

    public Role getRole(Integer roleId){
        Role role = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "SELECT role_id, description FROM noel.role WHERE role_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,roleId); // ? 의 순서를 말함 첫번째 물음표
            rs = ps.executeQuery();

            if(rs.next()){
                // 컬럼 인덱스 : SELECT 선택한 요소에 따라
                String description = rs.getString(2);
                int id = rs.getInt("role_id");

                role = new Role(id, description);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if( rs != null ){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if( ps != null ){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if( conn != null ){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return role;
    }
}
