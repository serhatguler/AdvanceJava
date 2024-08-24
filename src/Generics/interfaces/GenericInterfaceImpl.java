package Generics.interfaces;

//Generic Interfaceyi implement eden class da Generic olmak zorunda
public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    @Override
    public void printValue(T value) {
        System.out.println("bu methodda istedigimiz data tipini alabiliriz"+value);
    }

    @Override
    public T getValue() {
        return null;
    }
}
