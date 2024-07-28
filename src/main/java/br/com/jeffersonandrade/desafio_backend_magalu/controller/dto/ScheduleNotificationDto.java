package br.com.jeffersonandrade.desafio_backend_magalu.controller.dto;

import java.time.LocalDateTime;

import br.com.jeffersonandrade.desafio_backend_magalu.entity.Channel;
import br.com.jeffersonandrade.desafio_backend_magalu.entity.Notification;
import br.com.jeffersonandrade.desafio_backend_magalu.entity.Status;


public record ScheduleNotificationDto(
    LocalDateTime dateTime,
    String destination,
    String message,
    Channel.Values channel
) {
    

    public Notification toNotification(){
        return new Notification(
            dateTime, destination, message, channel.toChannel(), Status.Values.PENDING.toStatus());
    }
    
}
