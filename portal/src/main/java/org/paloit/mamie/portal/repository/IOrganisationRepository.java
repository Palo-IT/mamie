package org.paloit.mamie.portal.repository;

import org.paloit.mamie.portal.model.Organisation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IOrganisationRepository extends CrudRepository<Organisation, UUID> {

    @Override
    List<Organisation> findAll();
}
