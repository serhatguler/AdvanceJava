package Generics.interfaces.example;
//account ile ilgili DB islemleri
public class AccountRepo implements Repository<Account>{
    @Override
    public void save(Account object) {

    }

    @Override
    public Account get() {
        return null;
    }
}
