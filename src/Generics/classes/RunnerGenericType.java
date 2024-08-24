package Generics.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerGenericType {
    public static void main(String[] args) {


        GenericClass<String> obj1 = new GenericClass<>();
        obj1.setType("Generic Type");

        String str = obj1.getType();//CAstinge gerek yok

       GenericClass<Integer>  x = new GenericClass<>();
       x.setType(12);

       Integer num = x.getType();

       //GenericClass<String> obj3 = new GenericClass<>();
      // obj3.setType(12);//CTE, tur guvenli saglanir.-->ClassCastExc. engelliyor


        List<String> list = new ArrayList<>();
        list.add("Merhaba");
        list.add("java");
        //list.add(12); CTE, tur guvenli saglanir.-->ClassCastExc. engelliyor


        Map<String,Integer> map = new HashMap<>();
        map.put("generic",2);
       // map.put(2,2);CTE, tur guvenli saglanir.-->ClassCastExc. engelliyor


        //=============COKLU PARAMETRELI CLASS===================

        GenericClassTwoParam<String,Integer> myMap = new GenericClassTwoParam<>();
        myMap.setField("Java");
        myMap.setType(1);
        System.out.println(myMap.getField()+ " "+ myMap.getType());



    }

}
