package com.guardian.GuardianWorkflows.dao;

import java.util.List;
import java.util.Optional;

/**
 * Interface for RecordReader
 * @param <T> Type
 * @param <K> Key Type
 */
public interface RecordReader<T, K> {
    public Optional<T> read(K key);
    public List<T> readKeys(List<K> keys);
}
