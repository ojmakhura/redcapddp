package bw.ub.ehealth.redcapddp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "redcap_ddp_metadata", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "project_id",
                "field"
        })
})
public class Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "field", nullable = false)
    private String field;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "temporal", nullable = false)
    private String temporal = "0";

    @Column(name = "category", nullable = true)
    private String category;

    @Column(name = "subcategory", nullable = true)
    private String subcatergory;

    @Column(name = "identifier", nullable = false)
    private String identifier;

    public Metadata() {
    }

    public Metadata(Long projectId, String field, String label, String description, String temporal, String category, String subcatergory, String identifier) {
        this.projectId = projectId;
        this.field = field;
        this.label = label;
        this.description = description;
        this.temporal = temporal;
        this.category = category;
        this.subcatergory = subcatergory;
        this.identifier = identifier;
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

    public String getSubcatergory() {
        return subcatergory;
    }

    public void setSubcatergory(String subcatergory) {
        this.subcatergory = subcatergory;
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
        Metadata metadata = (Metadata) o;
        return projectId.equals(metadata.projectId) &&
                field.equals(metadata.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, field);
    }

    public static Metadata instance() {
        Metadata metadata = new Metadata();

        return metadata;
    }
}
