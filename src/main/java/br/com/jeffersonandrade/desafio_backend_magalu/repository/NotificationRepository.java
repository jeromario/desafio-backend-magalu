package br.com.jeffersonandrade.desafio_backend_magalu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeffersonandrade.desafio_backend_magalu.entity.Notification;
import br.com.jeffersonandrade.desafio_backend_magalu.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> of, LocalDateTime dateTime);

}
