package com.example.api.esportes.resource;

import com.example.api.esportes.dto.ParticipanteDto;
import com.example.api.esportes.service.ParticipanteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/participantes")
@CrossOrigin(origins = "*")
public class ParticipanteResource {

    final ParticipanteService participanteService;

    public ParticipanteResource(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ParticipanteDto create(@RequestBody ParticipanteDto dto) {
        log.info("ParticipanteResource::create");
        return participanteService.create(dto);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ParticipanteDto get(@PathVariable Integer id) {
        log.info("ParticipanteResource::get(id)");
        return participanteService.read(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ParticipanteDto> get() {
        log.info("ParticipanteResource::get()");
        return participanteService.read();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ParticipanteDto update(@PathVariable Integer id, @RequestBody ParticipanteDto dto) {
        log.info("ParticipanteResource::update(id, dto)");
        return participanteService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("ParticipanteResource::delete(id)");
        participanteService.delete(id);
    }
}
