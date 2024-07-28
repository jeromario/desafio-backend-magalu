package br.com.jeffersonandrade.desafio_backend_magalu.scheduler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.jeffersonandrade.desafio_backend_magalu.service.NotificationService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MagaluTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);
    private final NotificationService notificationService;


    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks(){

        LocalDateTime dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }

}
