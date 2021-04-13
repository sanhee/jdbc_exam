import dao.RoleDao;
import dto.Role;

import java.util.Arrays;
import java.util.List;

public class JDBCExam3 {
    public static void main(String[] args) {

        RoleDao dao = new RoleDao();
        List<Role> roleList = dao.getRoles();

        System.out.println(Arrays.toString(roleList.toArray()));

    }
}
