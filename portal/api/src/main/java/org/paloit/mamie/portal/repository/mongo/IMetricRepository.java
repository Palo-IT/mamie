package org.paloit.mamie.portal.repository.mongo;

import org.paloit.mamie.portal.entities.mongo.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface IMetricRepository extends MongoRepository<Metric, Long> {
    List<Metric> findAllByComponentUUID(UUID applicationComponentUUID);
    List<Metric> findAllByComponentUUIDAndTimeStampGreaterThanAndTimeStampLessThan(UUID applicationUUID, long startInterval, long stopInterval);
}
