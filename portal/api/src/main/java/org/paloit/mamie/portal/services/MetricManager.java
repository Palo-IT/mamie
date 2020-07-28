package org.paloit.mamie.portal.services;

import org.paloit.mamie.portal.entities.mongo.Metric;
import org.paloit.mamie.portal.repository.mongo.IMetricRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class MetricManager implements IMetricsManager {

    private final IMetricRepository metricsRepository;

    public MetricManager(IMetricRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @Override
    public Metric saveMetric(Metric metric) {
        return metricsRepository.save(metric);
    }

    @Override
    public Collection<Metric> saveMetric(Collection<Metric> metrics) {
        return metricsRepository.saveAll(metrics);
    }

    @Override
    public Collection<Metric> getMetricsForComponent(UUID componentUUID) {
        return metricsRepository.findAllByComponentUUID(componentUUID);
    }
}
