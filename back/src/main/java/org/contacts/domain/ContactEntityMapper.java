package org.contacts.domain;

import org.contacts.business.dtos.ContactDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactEntityMapper {
    ContactEntity toEntity(ContactDto contactDto);

    ContactDto toDto(ContactEntity contactEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ContactEntity partialUpdate(ContactDto contactDto, @MappingTarget ContactEntity contactEntity);
}