package Generics.classes;

//birden fazla referans data tipini alan generic class
public class GenericClassTwoParam<S,U>{

    //2 tane field olsun farkli data tiplerini referanss alsin

    private S field;
    private U type;

    public S getField() {
        return field;
    }

    public void setField(S field) {
        this.field = field;
    }

    public U getType() {
        return type;
    }

    public void setType(U type) {
        this.type = type;
    }
}
