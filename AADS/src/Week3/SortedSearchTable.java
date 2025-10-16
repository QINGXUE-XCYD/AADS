package Week3;

import java.util.*;

public class SortedSearchTable<K, V> extends AbstractSortedMap<K, V> {

    private List<Map.Entry<K, V>> table = new ArrayList<>();


    public SortedSearchTable(List<Entry<K, V>> table) {
        super();
        this.table = table;
    }

    @Override
    public Comparator<? super K> comparator() {
        return null; // 使用自然排序
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return new SortedSearchTable<>(table.subList(findIndex(fromKey), findIndex(toKey)));
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        int index = findIndex(toKey);
        return new SortedSearchTable<>(table.subList(0, index));
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        int index = findIndex(fromKey);
        return new SortedSearchTable<>(table.subList(index, table.size()));
    }

    @Override
    public K firstKey() {
        return table.get(0).getKey();
    }

    @Override
    public K lastKey() {
        return table.get(table.size() - 1).getKey();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(table);
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

    @Override
    public V get(Object key) {
        K k = (K) key;
        int index = findIndex(k);
        if (index == table.size() || compare(k, table.get(index).getKey()) != 0) {
            return null; // key 不存在
        }
        return table.get(index).getValue();
    }

    @Override
    public V put(K key, V value) {
        int index = findIndex(key);
        if (index < table.size() && compare(key, table.get(index).getKey()) == 0) {
            V oldValue = table.get(index).getValue();
            table.get(index).setValue(value);
            return oldValue;
        } else
            table.add(index, new AbstractMap.SimpleEntry<>(key, value));
        return null;
    }

    @Override
    public V remove(Object key) {
        K k = (K) key;
        int index = findIndex(k);
        if (index < table.size() && compare(k, table.get(index).getKey()) == 0) {
            return table.remove(index).getValue();
        }
        return null;
    }

}

