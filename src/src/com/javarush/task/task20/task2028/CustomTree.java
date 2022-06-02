package src.com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    Entry<String> lastAddedEntry;
    //public List<Entry<String>> removableKnots = new ArrayList<>();
    //public List<Entry<String>> listOfEntries = new ArrayList<>();




    public CustomTree() {
        this.root = new Entry("Root");
        lastAddedEntry = root;

    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return listOfEntries(root);
    }

    private int listOfEntries(Entry entry) {
        int count = 0;
        List<Entry<String>> list = new ArrayList<>();
        if (!entry.availableToAddLeftChildren) {
            count++;
            list.add(entry.leftChild);
        }
        if (!entry.availableToAddRightChildren) {
            count++;
            list.add(entry.rightChild);
        }
        for (Entry<String> item : list){
            count += this.listOfEntries(item);
        }
        return count;
    }




        @Override
        public String set ( int index, String element){
        throw new UnsupportedOperationException();
    }
        @Override
        public void add ( int index, String element){
        throw new UnsupportedOperationException();
    }
        @Override
        public String remove ( int index){
        throw new UnsupportedOperationException();
    }
        @Override
        public List<String> subList ( int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
        @Override
        protected void removeRange ( int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
        @Override
        public boolean addAll ( int index, Collection<? extends String > c){
        throw new UnsupportedOperationException();
    }


    public String getParent (String s){
        if (root.get(s, root) == null) {
            return null;
        }
        return root.get(s, root).parent.elementName;
    }



    @Override
    public boolean add(String s){
        Entry<String> newEntry = new Entry<>(s);
        boolean result = false;

        if (lastAddedEntry == root) {
            root.leftChild = newEntry;
            newEntry.parent = root;
            lastAddedEntry = root.leftChild;
            root.availableToAddLeftChildren = false;
            return true;
        }

        if (lastAddedEntry.parent.availableToAddRightChildren == false && lastAddedEntry.parent.rightChild == lastAddedEntry) {
            Entry metaEntryUp = this.goUp(lastAddedEntry);
            Entry metaEntry = this.goDown(metaEntryUp);
            metaEntry.leftChild = newEntry;
            metaEntry.leftChild.parent = metaEntry;
            metaEntry.availableToAddLeftChildren = false;
           // System.out.println("послдений элемент " + lastAddedEntry.elementName);
           // System.out.println("добавляем элемент: " + newEntry.elementName + " L");
           // System.out.println("его родитель" + newEntry.parent.elementName);
            result = true;
        } else {
            lastAddedEntry.parent.rightChild = newEntry;
            lastAddedEntry.parent.availableToAddRightChildren = false;
            newEntry.parent = lastAddedEntry.parent;
            result = true;
            //System.out.println("послдений элемент " + lastAddedEntry.elementName);
            //System.out.println("добавляем элемент: " + newEntry.elementName + " R");
            //System.out.println("его родитель" + newEntry.parent.elementName);

        }
        lastAddedEntry = newEntry;
        //listOfEntries.add(newEntry);
        return result;
    }

    private Entry goUp(Entry item) {
        Entry result = null;
        if (item.parent != root) {
            while (item == item.parent.rightChild) {
                if (item.parent != root) {
                    item = item.parent;
                } else {
                    return root;
                }
            }
        } else {
            return root;
        }
        result = item;
        return result;
    }

    private Entry goDown(Entry item){
        if (item != root) {
            item = item.parent.rightChild;
        }
        while (!item.availableToAddLeftChildren) {
            item = item.leftChild;
        }
        return item;
    }




    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;

        }

        public boolean isAvailableToAddChildren() {
            return (this.availableToAddLeftChildren || this.availableToAddRightChildren);
        }



        public Entry<String> get(String name, Entry rootEntry) {
            Entry result = null;
            if (rootEntry.elementName.equals(name)) {
                result = rootEntry;
            } else {
                if (rootEntry.leftChild != null) {
                    result = get(name, rootEntry.leftChild);
                }
                if (rootEntry.rightChild != null && result == null) {
                    result = get(name, rootEntry.rightChild);
                }
            }
            return result;
        }
    }
}
