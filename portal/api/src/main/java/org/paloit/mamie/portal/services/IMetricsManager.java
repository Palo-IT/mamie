package org.paloit.mamie.portal.services;

import org.paloit.mamie.portal.entities.mongo.Metric;

import java.util.Collection;
import java.util.UUID;

public interface IMetricsManager {
    Metric saveMetric(Metric metricDto);
    Collection<Metric> saveMetric(Collection<Metric> metricDto);
    Collection<Metric> getMetricsForComponent(UUID componentUUID);
}
