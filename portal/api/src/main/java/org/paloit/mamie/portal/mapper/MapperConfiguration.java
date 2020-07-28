package org.paloit.mamie.portal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfiguration {
    @Bean
    ModelMapper configure() {
        ModelMapper configured = new ModelMapper();
        configured.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return configured;
    }
}
