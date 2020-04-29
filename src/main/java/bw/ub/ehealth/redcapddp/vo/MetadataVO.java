package bw.ub.ehealth.redcapddp.vo;

import java.io.Serializable;
import java.util.Objects;

public class MetadataVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8436323900422501454L;
	private Long id;
    private Long projectId;
    private String field;
    private String label;
    private String description;
    private String temporal;
    private String category;
    private String subcategory;
    private String identifier;

    public MetadataVO(Long id, Long projectId, String field, String label, String description, String temporal, String category, String subcategory, String identifier) {
        this.id = id;
        this.projectId = projectId;
        this.field = field;
        this.label = label;
        this.description = description;
        this.temporal = temporal;
        this.category = category;
        this.subcategory = subcategory;
        this.identifier = identifier;
    }

    public MetadataVO() {
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataVO that = (MetadataVO) o;
        return Objects.equals(projectId, that.projectId) &&
                Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, field);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append(field + "\",\n");

        builder.append("    \"label\" : \"");
        builder.append(label + "\",\n");

        builder.append("    \"description\" : \"");
        builder.append(description + "\",\n");

        builder.append("    \"temporal\" : \"");
        builder.append(temporal + "\",\n");

        builder.append("    \"category\" : \"");
        builder.append(category + "\",\n");

        builder.append("    \"subcategory\" : \"");
        builder.append(subcategory + "\",\n");

        builder.append("    \"identifier\" : \"");
        builder.append(identifier + "\",\n");

        builder.append("}\n");
        return builder.toString();
    }
}
