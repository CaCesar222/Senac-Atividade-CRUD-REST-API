package com.example.api.esportes.resource;

import com.example.api.esportes.dto.GrupoDto;
import com.example.api.esportes.interfaces.IResource;
import com.example.api.esportes.service.GrupoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = "*")
public class GrupoResource implements IResource<GrupoDto, Integer> {

    private final GrupoService grupoService;

    public GrupoResource(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public GrupoDto create(@RequestBody GrupoDto entity) {
        log.info("GrupoResource::create");
        return grupoService.create(entity);
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public GrupoDto get(@PathVariable Integer id) {
        log.info("GrupoResource::get(id)");
        return grupoService.read(id);
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GrupoDto> get() {
        log.info("GrupoResource::get()");
        return grupoService.read();
    }

    @Override
    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GrupoDto update(@PathVariable Integer id, @RequestBody GrupoDto entity) {
        log.info("GrupoResource::update(id,entity)");
        return grupoService.update(id, entity);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("GrupoResource::delete(id)");
        grupoService.delete(id);
    }
}
