package domain.iterator;

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}
