package org.contacts.business.services;

import org.contacts.business.dtos.ContactDto;
import org.contacts.domain.ContactEntity;
import org.contacts.domain.ContactEntityMapper;
import org.contacts.domain.ContactService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServices {

    @Resource
    private ContactService contactService;
    @Resource
    private ContactEntityMapper contactMapper;

    public void createContact(ContactDto contactDto) {
        ContactEntity contactEntity = contactMapper.toEntity(contactDto);
        contactService.createContact(contactEntity);
    }


    public List<ContactDto> getAllContacts() {
        List<ContactEntity> contactList = contactService.getAllContacts();
        List<ContactDto> contactDtoList = new ArrayList<>();

        for (ContactEntity contact : contactList) {
            contactDtoList.add(contactMapper.toDto(contact));
        }

        return contactDtoList;
    }

    public List<ContactDto> getContact(String name) {

        if (contactService.getContact(name) == null) {

            System.out.println("Contact not found");
            return new ArrayList<>();
        }
        List<ContactEntity> contactList = contactService.getContact(name);
        List<ContactDto> contactDtoList = new ArrayList<>();

        System.out.println("Contact found");
        for (ContactEntity contact : contactList) {
            contactDtoList.add(contactMapper.toDto(contact));
            }

        return contactDtoList;

    }
    public void deleteContact(Integer id) {
        contactService.deleteContact(id);
    }

}





