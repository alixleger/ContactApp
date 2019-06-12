package contact.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import contact.form.ContactForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@JacksonXmlRootElement(localName = "contact")
public class Contact implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty
    private String firstName;

    @JacksonXmlProperty
    private String lastName;

    @JacksonXmlProperty
    private String phoneNumber;

    @JacksonXmlProperty
    private String address;

    @JacksonXmlProperty
    private String email;

    public Long getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected Contact() {}

    public Contact(String firstName, String lastName, String phoneNumber, String address, String email) {
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.address     = address;
        this.phoneNumber = phoneNumber;
        this.email       = email;
    }

    public Contact(ContactForm form) {
        this.firstName   = form.getFirstname();
        this.lastName    = form.getLastname();
        this.address     = form.getAddress();
        this.phoneNumber = form.getPhoneNumber();
        this.email       = form.getEmail();
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, firstName='%s', lastName='%s', address='%s', phoneNumber='%s', email='%s']",
                id, firstName, lastName, address, phoneNumber, email);
    }

}