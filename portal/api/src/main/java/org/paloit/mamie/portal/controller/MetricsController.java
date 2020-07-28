package org.paloit.mamie.portal.controller;

import org.modelmapper.ModelMapper;
import org.paloit.mamie.portal.dto.MetricDto;
import org.paloit.mamie.portal.entities.mongo.Metric;
import org.paloit.mamie.portal.services.IMetricsManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("metrics")
public class MetricsController {

    private final IMetricsManager metricsManager;
    private final ModelMapper modelMapper;

    public MetricsController(IMetricsManager metricsManager, ModelMapper modelMapper) {
        this.metricsManager = metricsManager;
        this.modelMapper = modelMapper;
    }

    @PutMapping("/add")
    void postNewMetrics(@RequestBody MetricDto metricDto) {
        metricsManager.saveMetric(modelMapper.map(metricDto, Metric.class));
    }

    @PutMapping("/addAll")
    void postListNewMetrics(@RequestBody Collection<MetricDto> metricDto) {
        metricsManager.saveMetric(modelMapper.map(metricDto, Metric.class));
    }

    @GetMapping("/{componentUUID}")
    List<MetricDto> getMetricsForComponent(@PathVariable UUID componentUUID) {
        final Collection<Metric> metricForComponent = metricsManager.getMetricsForComponent(componentUUID);
        return metricForComponent
                .stream()
                .map(metrics -> modelMapper.map(metrics, MetricDto.class))
                .collect(Collectors.toList());
    }

}
