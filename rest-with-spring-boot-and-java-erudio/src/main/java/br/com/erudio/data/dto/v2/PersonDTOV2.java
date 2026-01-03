package br.com.erudio.data.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonDTOV2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String gender;

    public PersonDTOV2() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTOV2 that)) return false;
        return getId() == that.getId() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getBirthDate(), that.getBirthDate()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBirthDate(), getAddress(), getGender());
    }
}
