package Generics.interfaces.example;
//tum repolar bu standatea uymali
public interface Repository<T> {

    void save(T object);
     T get();
}
