package org.contacts.business.dtos;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.contacts.domain.ContactEntity}
 */
@Value
public class ContactDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String name;
    @Size(max = 255)
    String codeName;
    @Size(max = 15)
    String phoneNumber;
}