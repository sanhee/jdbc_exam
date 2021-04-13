import dao.RoleDao;

public class JDBCExam5 {
    public static void main(String[] args) {
        RoleDao dao = new RoleDao();

        System.out.println(dao.update(  500,"변경함"));
    }
}
