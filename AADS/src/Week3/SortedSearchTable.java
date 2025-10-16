package Week3;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;

public class SortedSearchTable<K,V> extends AbstractSortedMap<K,V> {
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    @Override
    public K firstKey() {
        return null;
    }

    @Override
    public K lastKey() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }
}
