package org.paloit.mamie.test.monitored.back.spring.boot.controller;

import org.paloit.mamie.test.monitored.back.spring.boot.service.ILoadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("load")
public class SimpleLoadController {

    private final ILoadService loadService;

    public SimpleLoadController(ILoadService loadService) {
        this.loadService = loadService;
    }

    @GetMapping("simple/{durationSeconds}")
    public void doSimpleLoad(@PathVariable long durationSeconds) {
        this.loadService.doFullCPULoad(durationSeconds);
    }
}
