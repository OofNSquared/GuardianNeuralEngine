package com.guardian.GuardianWorkflows.dao;

import java.util.List;
import java.util.Optional;

/**
 * Interface for RecordReader
 * @param <T> Type
 * @param <K> Key Type
 */
public interface RecordReader<T, K> {
    Optional<T> read(K key);
    List<T> readKeys(List<K> keys);
}
