package bw.ub.ehealth.redcapddp.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PatientVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7748471701313644532L;

	private Long id;

    private String idNumber;
    private String surname;
    private String firstName;
    private String contactNumber;
    private Date dob;
    private String sex;
    private Integer age = null;
    private Set<SpecimenVO> specimens;

    public PatientVO() {
    }

    public PatientVO(Long id, String idNumber, String surname, String firstName, String contactNumber, Date dob, String sex) {
        this.idNumber = idNumber;
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.sex = sex;

        this.specimens = new HashSet<>();

        LocalDate _dob = LocalDate.parse(dob.toString(), DateTimeFormatter.ofPattern("dd/mm/yyyy"));
        LocalDate now = LocalDate.now();
        Period diff = Period.between(_dob, now);

        this.age = diff.getYears();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<SpecimenVO> getSpecimens() {
        return specimens;
    }

    public void addSpeciment(SpecimenVO specimen) {
        this.specimens.add(specimen);
    }

    public void setSpecimens(Set<SpecimenVO> specimens) {
        this.specimens = specimens;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        // idNumber
        builder.append("{\n");
        builder.append("\"field\" : \"");
        builder.append("idNumber" + "\",\n");

        builder.append("\"value\" : \"");
        builder.append(idNumber + "\"\n");

        builder.append("},");

        // firstName
        builder.append("{\n");
        builder.append("\"field\" : \"");
        builder.append("firstName" + "\",\n");

        builder.append("\"value\" : \"");
        builder.append(firstName + "\"\n");

        builder.append("},");

        // surname
        builder.append("{\n");
        builder.append("\"field\" : \"");
        builder.append("surname" + "\",\n");

        builder.append("\"value\" : \"");
        builder.append(surname + "\"\n");

        builder.append("},");

        // contactNumber
        builder.append("{\n");
        builder.append("\"field\" : \"");
        builder.append("contactNumber" + "\",\n");

        builder.append("\"value\" : \"");
        builder.append(contactNumber + "\"\n");

        builder.append("},");

        // dob
        builder.append("{\n");
        builder.append("\"field\" : \"");
        builder.append("dob" + "\",\n");

        builder.append("\"value\" : \"");
        builder.append(dob + "\"\n");

        builder.append("},");

        // dob
        builder.append("{\n");
        builder.append("\"field\" : \"");
        builder.append("sex" + "\",\n");

        builder.append("\"value\" : \"");
        builder.append(sex + "\"\n");

        builder.append("}");

        specimens.forEach(specimen -> builder.append("," + specimens.toString()));

        return builder.toString();
    }
}
