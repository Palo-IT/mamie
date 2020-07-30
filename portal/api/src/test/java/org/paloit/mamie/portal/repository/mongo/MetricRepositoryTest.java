package org.paloit.mamie.portal.repository.mongo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.paloit.mamie.portal.entities.mongo.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.UUID;

@DataMongoTest
class MetricRepositoryTest {

    @Autowired
    private IMetricRepository metricsRepository;

    final UUID app1UUID = UUID.randomUUID();
    final UUID app2UUID = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        final List<Metric> metrics = List.of(
                new Metric(app1UUID, 1, 3),
                new Metric(app1UUID, 2, 2),
                new Metric(app1UUID, 3, 1),
                new Metric(app1UUID, 4, 3),
                new Metric(app1UUID, 5, 1),
                new Metric(app1UUID, 6, 3),

                new Metric(app2UUID, 1, 3),
                new Metric(app2UUID, 2, 4),
                new Metric(app2UUID, 10, 3)
        );
        metricsRepository.saveAll(metrics);
    }

    @Test
    void findAllByComponentUUID() {
        final List<Metric> allByComponentUUID = metricsRepository.findAllByComponentUUID(app1UUID);
        Assertions.assertEquals(6, allByComponentUUID.size());
        final List<Metric> allByComponentUUID2 = metricsRepository.findAllByComponentUUID(app2UUID);
        Assertions.assertEquals(3, allByComponentUUID2.size());
    }

    @Test
    void findAllByComponentUUIDAndTimestampGreaterThanAndTimestampLessThan() {
    }


}