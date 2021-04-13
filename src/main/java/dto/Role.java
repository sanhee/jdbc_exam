package dto;

public class Role {

    //+-------------+--------------+------+-----+---------+-------+
    //| Field       | Type         | Null | Key | Default | Extra |
    //+-------------+--------------+------+-----+---------+-------+
    //| role_id     | int(11)      | NO   | PRI | NULL    |       |
    //| description | varchar(100) | YES  |     | NULL    |       |
    //+-------------+--------------+------+-----+---------+-------+

    private Integer roleId;
    private String description;

    public Role(Integer roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", description='" + description + '\'' +
                '}';
    }
}
