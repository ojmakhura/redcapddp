package bw.ub.ehealth.redcapddp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "redcap_user_rights")
public class UserRight implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6008581815520972373L;

	@Id
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "username")
    private String username;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "group_id")
    private Long groupId;

	public UserRight(Long id, Long projectId, String username, Long roleId, Long groupId) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.username = username;
		this.roleId = roleId;
		this.groupId = groupId;
	}

	public UserRight() {
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
}
