package com.example.api.esportes.resource;

import com.example.api.esportes.dto.UsuarioDto;
import com.example.api.esportes.interfaces.IResource;
import com.example.api.esportes.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioResource implements IResource<UsuarioDto, Integer> {

    final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public UsuarioDto create(@RequestBody UsuarioDto entity) {
        log.info("UsuarioResource::create");
        return usuarioService.create(entity);
    }

    @Override
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UsuarioDto get(@PathVariable Integer id) {
        log.info("UsuarioResource::get(id)");
        return usuarioService.read(id);
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsuarioDto> get() {
        log.info("UsuarioResource::get()");
        return usuarioService.read();
    }

    @Override
    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public UsuarioDto update(@PathVariable Integer id, @RequestBody UsuarioDto entity) {
        log.info("ShipperResource::update(id,entity)");
        return usuarioService.update(id, entity);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("UsuarioResource::delete(id)");
        usuarioService.delete(id);
    }
}
