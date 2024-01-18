package org.contacts.business.controllers;
import io.swagger.v3.oas.annotations.Operation;
import org.contacts.business.dtos.ContactDto;
import org.contacts.business.services.ContactServices;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import java.util.List;


@RestController
@RequestMapping("/contact")

public class ContactsController {

    @Resource
    private ContactServices contactServices;


    @GetMapping("/name")
    @Operation(summary = "Get contact by name")
    public List<ContactDto> getContacts(@RequestParam String name, @RequestParam Boolean all) {

        if (all) {
            return contactServices.getAllContacts();
        }
        System.out.println("name: " + name);
        return contactServices.getContact(name);

    }
    @DeleteMapping("/id")
    @Operation(summary = "Delete contact by id")
    public void deleteContact(@RequestParam Integer id) {
        contactServices.deleteContact(id);
    }




}
