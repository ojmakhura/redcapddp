package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCredentials {

    private String id;
    private Boolean disabled;
    private String username;

    public UserCredentials() {
    }

    public UserCredentials(String id, Boolean disabled, String username) {
        this.id = id;
        this.disabled = disabled;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentials that = (UserCredentials) o;
        return id.equals(that.id) &&
                username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", disabled=" + disabled +
                ", username='" + username + '\'' +
                '}';
    }
}
