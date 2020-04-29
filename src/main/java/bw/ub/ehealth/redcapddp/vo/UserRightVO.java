package bw.ub.ehealth.redcapddp.vo;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class UserRightVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8334817890875055225L;
	private Long id;
    private Long projectId;
    private String username;
    private Long roleId;
    private Long groupId;

    public UserRightVO() {
    }

    public UserRightVO(Long id, Long projectId, String username, Long roleId, Long groupId) {
        this.id = id;
        this.projectId = projectId;
        this.username = username;
        this.roleId = roleId;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRightVO that = (UserRightVO) o;
        return projectId.equals(that.projectId) &&
                username.equals(that.username) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, username, roleId, groupId);
    }

    @Override
    public String toString() {
        return "UserRightVO{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", username='" + username + '\'' +
                ", roleId=" + roleId +
                ", groupId=" + groupId +
                '}';
    }
}
