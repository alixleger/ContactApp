package contact.controller;

import contact.entity.Contact;
import contact.entity.Contacts;
import contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiController extends ContactController
{
    @Autowired
    public ApiController(ContactRepository repository) {
        super(repository);
    }

    @GetMapping(value = "/contacts", produces = {MediaType.APPLICATION_XML_VALUE})
    public Contacts getContacts() {
        Contacts contacts = new Contacts();
        contacts.setContacts((List<Contact>) repository.findAll());
        return contacts;
    }

    @GetMapping(value = "/contact/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
    public Contact getContactById(@PathVariable(name="id") Long id)
    {
        return repository.findById(id).orElse(null);
    }

    @GetMapping(value = "/contact/{id}/delete", produces = {MediaType.APPLICATION_XML_VALUE})
    public String deleteContact(@PathVariable(name="id") Long id)
    {
        repository.deleteById(id);
        return "OK";
    }

    @PostMapping(value = "/contact", consumes = {MediaType.APPLICATION_XML_VALUE})
    public String createContact(@RequestBody Contact contact)
    {
        if (contact.getId() != null) {
            return "Contact element should not have id attribute for creation";
        }
        repository.save(contact);

        return "OK";
    }

    @PostMapping(value = "/contact/{id}", consumes = {MediaType.APPLICATION_XML_VALUE})
    public String updateContact(@PathVariable(name="id") Long id, @RequestBody Contact contact)
    {
        if (!id.equals(contact.getId())) {
            return "WRONG ID";
        }
        repository.save(contact);

        return "OK";
    }
}
