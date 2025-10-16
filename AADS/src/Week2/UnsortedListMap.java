package Week2;

import java.util.*;

public class UnsortedListMap<K,V> extends AbstractMap<K,V>{


    // Set a List
    public List<MapEntry<K,V>> map = new ArrayList();

    // 构造函数
    public UnsortedListMap() {}

    @Override
    public int size() {
        return map.size();
    }

    private int findKey(K key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getKey().equals(key)) {
                return i;
            }
        }
        // Not found
        return -1;
    }

    private int findValue(V value) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getValue().equals(value)) {
                return i;
            }
        }
        // Not found
        return -1;
    }

    @Override
    public V get(Object key) {
        int index = findKey((K) key);
        if (index != -1) {
            return map.get(index).getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = findKey(key);
        if (index != -1) {
            return map.get(index).setValue(value);
        } else {
            map.add(new MapEntry<>(key, value));
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = findKey((K) key);
        if (index != -1) {
            int n = size();
            V value = map.get(index).getValue();
            if (index != n - 1) {
                map.set(index, map.get(n - 1));
            }
            map.remove(n - 1);
            return value;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return findKey((K) key) != -1;
    }

    @Override
    public boolean containsValue(Object value) {
        return findValue((V) value) != -1;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(map);
    }
}
