package contact.form;


import javax.validation.constraints.*;

public class ContactForm {

    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max=30)
    private String lastname;

    @NotNull
    @Size(min=2, max=30)
    private String address;

    @NotNull
    @Size(min=10, max=12)
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    private Long id;

    public ContactForm(@NotNull @Size(min = 2, max = 30) String firstname, @NotNull @Size(min = 2, max = 30) String lastname, @NotNull String address, @NotNull @Size(min = 10, max = 12) String phoneNumber, @NotNull @Email String email, Long id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}