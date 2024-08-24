package Generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {
        //classtan 2 nesne olsun

        NonGenericType nonGenericType1 = new NonGenericType();
        NonGenericType nonGenericType2 = new NonGenericType();

        nonGenericType1.setObject("Advanced java"); //String ile set edildi

        nonGenericType2.setObject(23); //Integer ile set ettik


        //--------------------------------------------------

        String str1 =(String) nonGenericType1.getObject(); //Cast problemi aldik

        System.out.println(str1);

        String str2 =(String) nonGenericType2.getObject();
        System.out.println(str2);//Run Time Exception:ClassCastException



        //olmasi gereken
        Integer num =(Integer) nonGenericType2.getObject();
        System.out.println(num);


    }
}
