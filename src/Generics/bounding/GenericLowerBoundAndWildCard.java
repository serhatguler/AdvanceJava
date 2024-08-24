package Generics.bounding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericLowerBoundAndWildCard {

    public static void main(String[] args) {

        System.out.println("======wildcard ile alttan sinirlama=====");
        List<Integer> integerList =new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addElements(integerList);
       // addElements(doubleList);//double integerin parenti olmadigi icin hata verir.Altan sinirlama yaptik
        System.out.println(integerList);


        System.out.println("======wildcard ile ustten sinirlama=====");
        multiplyBy2(integerList);
        multiplyBy2(doubleList);
        //multiplyBy2(objectList); listin data tipini ustten Number ile sinirlandik ust parent a gecemeyiz.

        System.out.println("======List<?>=====");
        printElements(integerList);
        printElements(doubleList);
        printElements(stringList);

        System.out.println("======List<Object>=====");
        printObjectElements(objectList);
//        printObjectElements(stringList);
//        printObjectElements(integerList);//List<Object> List<String> in parenti degildir.



    }
    //alttan sinirlama
    //parametrede verilen listeye 1...10 a kadar eleman ekleme
    //List in data tipi sadece Integer,Number veya Object olsun
    // List<? super Integer> bu integer number veya obje olur . yani alttan sinirladik
    //?(wildcard): bilinmeyen data tipi
    public static  void addElements(List<? super Integer> list){

        for (int i =0; i<=10;i++){
            list.add(i);
        }

    }

    //wild card ile ustten sinirlama
    public static void multiplyBy2(List<? extends Number> list){
        list.stream().map(t->t.doubleValue()*2).forEach(t-> System.out.print(t+" "));
    }

    //T:herhangi bir data tipi, ?:bilinmeyen data tipi
    //?: bazi kisitlamalari var.
    public static void printElements(List<?> unknownList ){
        //unknownList.add(1);//listin data tipi net degil bu yuzden add methouduna izin vermiyor
        //unknownList.add("java");
        //?: okumaya izin verir.degisiklik yapmaya izin vermez
        //?: Data tipinden bagimsiz metodlara izin verir.size,remove etc....

        unknownList.add(null);
        unknownList.forEach(t-> System.out.print(t+ " "));
    }

    //List<?> yerine List<Object>
    public static void printObjectElements(List<Object> objectList ){


        objectList.add("String");
        objectList.add(12);

        objectList.add(null);
        objectList.forEach(t-> System.out.print(t+ " "));
    }

    //Note:? ve T tamamen ayni degildir.

}
