package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class NamedEntity {
    private String id;
    private String name;
    private String shortName;
    private String displayName;

    public NamedEntity() {
    }

    public NamedEntity(String id, String name, String shortName, String displayName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedEntity that = (NamedEntity) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                shortName.equals(that.shortName) &&
                displayName.equals(that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, displayName);
    }
}
