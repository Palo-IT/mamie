package org.paloit.mamie.portal.repository.jpa;

import org.paloit.mamie.portal.entities.jpa.Organisation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrganisationRepository extends CrudRepository<Organisation, Long> {
    @Override
    List<Organisation> findAll();
}
