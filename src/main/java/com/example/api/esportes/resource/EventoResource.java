package com.example.api.esportes.resource;

import com.example.api.esportes.dto.EventoDto;
import com.example.api.esportes.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoResource {

    final EventoService eventoService;

    public EventoResource(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public EventoDto create(@RequestBody EventoDto dto) {
        log.info("EventoResource::create");
        return eventoService.create(dto);
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public EventoDto get(@PathVariable Integer id) {
        log.info("EventoResource::get(id)");
        return eventoService.read(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EventoDto> get() {
        log.info("EventoResource::get()");
        return eventoService.read();
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public EventoDto update(@PathVariable Integer id, @RequestBody EventoDto dto) {
        log.info("EventoResource::update(id, dto)");
        return eventoService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("EventoResource::delete(id)");
        eventoService.delete(id);
    }
}
