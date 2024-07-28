package br.com.jeffersonandrade.desafio_backend_magalu.service;







import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import br.com.jeffersonandrade.desafio_backend_magalu.controller.dto.ScheduleNotificationDto;
import br.com.jeffersonandrade.desafio_backend_magalu.entity.Notification;
import br.com.jeffersonandrade.desafio_backend_magalu.entity.Status;
import br.com.jeffersonandrade.desafio_backend_magalu.repository.NotificationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void scheduleNotification(ScheduleNotificationDto dto){
         notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
            Status.Values.PENDING.toStatus(),
            Status.Values.ERROR.toStatus()
        ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<? super Notification> sendNotification() {
        return n -> {
            // TODO - REALIZAR O ENVIO DA NOTIFICACAO
            
            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }

    
}
