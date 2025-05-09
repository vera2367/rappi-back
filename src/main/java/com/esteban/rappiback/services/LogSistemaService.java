package com.esteban.rappiback.services;

import com.esteban.rappiback.repositorys.LogSistemaRepository;
import org.springframework.stereotype.Service;

@Service
public class LogSistemaService {

    private final LogSistemaRepository logSistemaRepository;

    public LogSistemaService(LogSistemaRepository logSistemaRepository) {
        this.logSistemaRepository = logSistemaRepository;
    }


}
