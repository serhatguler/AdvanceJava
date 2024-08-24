package Generics.interfaces.example;
//customer ile ilgili DB islemleri
public class CustomerRepo implements Repository<Customer>{
    @Override
    public void save(Customer object) {

    }

    @Override
    public Customer get() {
        return null;
    }
}
