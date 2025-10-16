package Week3;

import java.util.*;

public class SortedSearchTable<K, V> extends AbstractSortedMap<K, V> {

    private List<Map.Entry<K, V>> table = new ArrayList<>();

    // constructor
    public SortedSearchTable() {
        super();
    }

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
        return new HashSet<>(table);
    }

    public SortedSearchTable(Comparator<K> c) {
        super(c);
    }


    private int findIndex(K key) {
        int low = 0;
        int high = table.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = compare(key, table.get(mid).getKey());
            if (cmp == 0) return mid;
            else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}

