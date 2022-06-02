package src.com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if(!cache.containsKey(key)){
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            V value = constructor.newInstance(key);
            cache.put(key, value);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}
