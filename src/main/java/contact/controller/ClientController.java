package contact.controller;

import contact.entity.Contact;
import contact.form.ContactForm;
import contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ClientController extends ContactController
{
    @Autowired
    public ClientController(ContactRepository repository) {
        super(repository);
    }

    @ModelAttribute("contacts")
    public Iterable<Contact> getContacts()
    {
        return repository.findAll();
    }

    @GetMapping({"/contacts", "/", ""})
    public String listContacts()
    {
        return "contacts";
    }

    @GetMapping("/contact/{id}")
    public String displayContactUpdateForm(@PathVariable(name="id") Long id, Model model)
    {
        Optional<Contact> optionalContact = repository.findById(id);
        if (!optionalContact.isPresent()) {
            return "redirect:/contacts";
        }
        model.addAttribute("contact", optionalContact.get());

        return "update";
    }

    @PostMapping("/contact/update")
    public String updateContact(@Valid ContactForm contactForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "redirect:/contact/" + contactForm.getId();
        }

        Optional<Contact> optionalContact = repository.findById(contactForm.getId());
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setFirstName(contactForm.getFirstname());
            contact.setLastName(contactForm.getLastname());
            contact.setAddress(contactForm.getAddress());
            contact.setEmail(contactForm.getEmail());
            contact.setPhoneNumber(contact.getPhoneNumber());

            repository.save(contact);
        }

        return "redirect:/contacts";
    }

    @GetMapping("/contact/{id}/delete")
    public String deleteContact(@PathVariable(name="id") Long id)
    {
        repository.deleteById(id);

        return "redirect:/contacts";
    }

    @GetMapping("/contact/add")
    public String displayContactAddForm(ContactForm form) {
        return "add";
    }

    @PostMapping("/contact/add")
    public String addContact(@Valid ContactForm contactForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "redirect:/contact/add";
        }
        repository.save(new Contact(contactForm));

        return "redirect:/contacts";
    }
}
