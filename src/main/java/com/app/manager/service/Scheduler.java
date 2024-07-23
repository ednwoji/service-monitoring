package com.app.manager.service;


import com.app.manager.connector.Processor;
import com.app.manager.entity.AppsEntity;
import com.app.manager.entity.Availability;
import com.app.manager.repository.AppEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Scheduler {

    @Autowired
    private AppEntityRepository appEntityRepository;

    @Autowired
    private Processor processor;

    @Scheduled(fixedDelay = 60000)
    public void monitorServices() {
        List<AppsEntity> services = appEntityRepository.findAll();
        log.info(services.toString());
        if (services != null && !services.isEmpty()) {
            services.parallelStream().forEach(service -> {
                boolean isAvailable = false;
                if (service.isUrlStatus()) {
                    isAvailable = processor.checkUrl(service.getUrlLink());
                } else {
                    isAvailable = processor.checkService(service.getIp(), service.getPort());
                }

                service.setAvailability(isAvailable ? Availability.AVAILABLE : Availability.OFFLINE);
                appEntityRepository.save(service);
            });
        }
    }
}
