package src.com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import static com.javarush.task.task37.task3707.HashMapReflectionHelper.callHiddenMethod;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max((int)(collection.size() / 0.75f) +1, 16));
        addAll(collection);
    }

    public boolean add(E e) {
        return map.put(e,PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            HashMap<E, Object> cloneMap = new HashMap<>();
            cloneMap = (HashMap) map.clone();
            newSet.map = cloneMap;
            return newSet;
        } catch (Exception e){
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();


        s.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        s.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map,"loadFactor"));

        s.writeInt(map.size());

        for (E e : map.keySet()) {
            s.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();

        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        map = new HashMap<>(capacity, loadFactor);

        int size = s.readInt();

        for (int i = 0; i < size; i++) {
            E e = (E)s.readObject();
            map.put(e,PRESENT);
        }
    }
}
