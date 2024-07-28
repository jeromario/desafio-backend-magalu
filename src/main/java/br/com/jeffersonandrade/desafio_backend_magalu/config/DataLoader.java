package br.com.jeffersonandrade.desafio_backend_magalu.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.jeffersonandrade.desafio_backend_magalu.entity.Channel;
import br.com.jeffersonandrade.desafio_backend_magalu.entity.Status;
import br.com.jeffersonandrade.desafio_backend_magalu.repository.ChannelRepository;
import br.com.jeffersonandrade.desafio_backend_magalu.repository.StatusRepository;
import lombok.AllArgsConstructor;


@Configuration
@AllArgsConstructor
public class DataLoader implements CommandLineRunner{

    private final StatusRepository statusRepository;
    private final ChannelRepository channelRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                    .map(Channel.Values::toChannel)
                    .forEach(channelRepository::save);
                    
        Arrays.stream(Status.Values.values())
                    .map(Status.Values::toStatus)
                    .forEach(statusRepository::save);
    }

}
