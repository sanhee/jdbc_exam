import dao.RoleDao;
import dto.Role;

public class JDBCExam1 {
    public static void main(String[] args) {
        RoleDao dao = new RoleDao();
        Role role = dao.getRole(1000);

        System.out.println(role);
    }
}
