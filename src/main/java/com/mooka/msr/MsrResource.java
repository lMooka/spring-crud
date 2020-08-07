package com.mooka.msr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public abstract class MsrResource<M extends IMsrModel<K>, S extends IMsrService<M, K>, K> {

    protected final S service;

    public MsrResource(S service) {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public M getCardById(@PathVariable K id) {
        return service.findById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public Iterable<M> getAll() {
        return service.findAll();
    }

    @PutMapping
    public M save(@RequestBody M model) {
        return service.save(model);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping
    public Iterable<M> save(@RequestBody Iterable<M> models) {
        return service.save(models);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public void delete(@RequestBody M model) {
        service.delete(model);
    }
}
