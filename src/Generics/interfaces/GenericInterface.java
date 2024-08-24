package Generics.interfaces;

//ornegin : repository->csutomer,account,user
public interface GenericInterface<T> {
    void printValue(T value);
    T getValue();
}
