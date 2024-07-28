package br.com.jeffersonandrade.desafio_backend_magalu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeffersonandrade.desafio_backend_magalu.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
