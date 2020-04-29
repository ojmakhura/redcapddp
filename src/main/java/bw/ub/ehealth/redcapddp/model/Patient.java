package bw.ub.ehealth.redcapddp.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "redcap_ddp_patient")
public class Patient implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5341630073229296391L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_number", nullable = false, unique = true)
    private String idNumber;

    @Column(name = "surname")
    private String surname;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "sex")
    private String sex;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private Set<Specimen> specimens = new HashSet<>();

    public Patient() {
    }

    public Patient(String idNumber, String surname, String firstName, String contactNumber, Integer age, Date dob, String sex) {
        this.idNumber = idNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSpecimens(Set<Specimen> specimens) {
        this.specimens = specimens;
    }

    public Set<Specimen> getSpecimens() {
        return this.specimens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return idNumber.equals(patient.idNumber) &&
                surname.equals(patient.surname) &&
                firstName.equals(patient.firstName) &&
                dob.equals(patient.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, surname, firstName, dob);
    }

    public static Patient instance() {
        Patient patient = new Patient();
        patient.setSpecimens(new HashSet<>());

        return patient;
    }
}
