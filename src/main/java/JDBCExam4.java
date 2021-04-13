import dao.RoleDao;

public class JDBCExam4 {
    public static void main(String[] args) {
        RoleDao dao = new RoleDao();

        System.out.println(dao.delete(1000));
    }
}
