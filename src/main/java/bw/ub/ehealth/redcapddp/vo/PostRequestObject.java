package bw.ub.ehealth.redcapddp.vo;

import java.io.Serializable;
import java.util.Arrays;

public class PostRequestObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4640278392226866336L;
	
	private String user;
	private String project_id;
	private String redcap_url;
	private String id;
	private Field[] fields;
	
	public PostRequestObject(String user, String project_id, String redcap_url, String id, Field[] fields) {

		this.user = user;
		this.project_id = project_id;
		this.redcap_url = redcap_url;
		this.id = id;
		this.fields = fields;
	}
	
	public PostRequestObject() {

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getRedcap_url() {
		return redcap_url;
	}

	public void setRedcap_url(String redcap_url) {
		this.redcap_url = redcap_url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "PostObject [user=" + user + ", project_id=" + project_id + ", redcap_url=" + redcap_url + ", id=" + id
				+ ", fields=" + Arrays.toString(fields) + "]";
	}
	
	
}
