package com.mooka.msr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class SpecificationMsrService<R extends CrudRepository<M, K> & JpaSpecificationExecutor<M>, M extends IMsrModel<K>, K> implements IMsrService<M, K>, JpaSpecificationExecutor<M> {
    protected final R repository;

    public SpecificationMsrService(R repository) {
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

    @Override
    public Optional<M> findOne(Specification<M> spec) {
        return repository.findOne(spec);
    }

    @Override
    public List<M> findAll(Specification<M> spec) {
        return repository.findAll(spec);
    }

    @Override
    public Page<M> findAll(Specification<M> spec, Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    @Override
    public List<M> findAll(Specification<M> spec, Sort sort) {
        return repository.findAll(spec, sort);
    }

    @Override
    public long count(Specification<M> spec) {
        return repository.count(spec);
    }
}
