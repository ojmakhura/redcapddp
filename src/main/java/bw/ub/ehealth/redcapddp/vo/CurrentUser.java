package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentUser {

    private String id;
    private String name;
    private String displayName;
    private String firstName;
    private String surname;
    private UserCredentials userCredentials;
    private List<String> programs;
    private List<String> dataSets;
    private List<Value> userGroups;
    private List<Value> dataViewOrganisationUnits;
    private List<Value> organisationUnits;
    private List<Value> userRoles;

    public CurrentUser(String id, String name, String displayName, String firstName, String surname, UserCredentials userCredentials) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.firstName = firstName;
        this.surname = surname;
        this.userCredentials = userCredentials;

        this.programs = new ArrayList<>();
        dataSets = new ArrayList<>();
        userGroups = new ArrayList<>();
        dataViewOrganisationUnits = new ArrayList<>();
        organisationUnits = new ArrayList<>();
        userRoles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }

    public List<String> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<String> dataSets) {
        this.dataSets = dataSets;
    }

    public List<Value> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<Value> userGroups) {
        this.userGroups = userGroups;
    }

    public List<Value> getDataViewOrganisationUnits() {
        return dataViewOrganisationUnits;
    }

    public void setDataViewOrganisationUnits(List<Value> dataViewOrganisationUnits) {
        this.dataViewOrganisationUnits = dataViewOrganisationUnits;
    }

    public List<Value> getOrganisationUnits() {
        return organisationUnits;
    }

    public void setOrganisationUnits(List<Value> organisationUnits) {
        this.organisationUnits = organisationUnits;
    }

    public List<Value> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Value> userRoles) {
        this.userRoles = userRoles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentUser that = (CurrentUser) o;
        return surname.equals(that.surname) && userCredentials.getUsername().equals(that.userCredentials.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, userCredentials.getUsername());
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", userCredentials=" + userCredentials.toString() +
                ", programs=" + programs +
                ", dataSets=" + dataSets +
                ", userGroups=" + userGroups +
                ", dataViewOrganisationUnits=" + dataViewOrganisationUnits +
                ", organisationUnits=" + organisationUnits +
                ", userRoles=" + userRoles +
                '}';
    }
}
