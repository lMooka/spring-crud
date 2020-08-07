package com.mooka.msr;

public interface IMsrService<M extends IMsrModel<K>, K> {
    Iterable<M> findAll();
    M findById(K id);
    M save(M model);
    Iterable<M> save(Iterable<M> model);
    boolean delete(M model);
}
