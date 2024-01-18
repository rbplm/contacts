package org.contacts.domain;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.Optional;


@Service
public class ContactService {
    @Resource
    private ContactRepository contactRepository;

    public List<ContactEntity> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<ContactEntity> getContact(String name) {
        List<ContactEntity> contactList = contactRepository.findByNameContainingIgnoreCase(name);
        if (contactList.size() == 0) {
            return null;
        }
        else {
            return contactList;
        }
    }
    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
