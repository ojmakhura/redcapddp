package bw.ub.ehealth.redcapddp.vo;

import java.io.Serializable;

public class Field implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8573056685793236358L;
	private String field;
	
	public Field() {
		
	}

	public Field(String field) {
		super();
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "field : " + field;
	}
}
