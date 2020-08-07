package com.mooka.msr;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class MsrService<R extends CrudRepository<M, K>, M extends IMsrModel<K>, K> implements IMsrService<M, K> {
    protected final R repository;

    public MsrService(R repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<M> findAll() {
        return repository.findAll();
    }

    @Override
    public M findById(K id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public M save(M model) {
        return repository.save(model);
    }

    @Override
    public Iterable<M> save(Iterable<M> models) {
        return repository.saveAll(models);
    }

    @Override
    public boolean delete(M model) {
        Optional<M> optionalModel = repository.findById(model.getId());
        repository.delete(model);
        return optionalModel.isPresent();
    }
}
