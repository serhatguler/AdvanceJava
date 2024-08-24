package Generics.methods;

import java.util.Arrays;

//Generic methodlar bize nasil kolaylik saglar
public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr ={2,34,43,56,77};
        String[] strArr ={"Java","Generics","Makes"};
        Double[] doubleArr = {3.2,2.3,4.4,6.66};

        System.out.println("-------generic olmayan methodlarda durum bu--------");
        printArr(intArr);
        printArr(strArr);
        printArr(doubleArr);

        System.out.println("-------generic methodlarda durum bu--------");
        printAllArray(intArr);
        printAllArray(strArr);
        printAllArray(doubleArr);

        System.out.println("-------sonuc donduren generic methodlarda durum bu--------");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(strArr));
        System.out.println(getFirst(doubleArr));

        System.out.println("birden fazla parametre ile generic method");
        Integer number =88;
        printArrAndObject(strArr,number);

    }


    //arraylari yazdrimak icin method olusturalim

    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //OVERLOADING
    public static void printArr(String[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //OVERLOADING
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //Generic method olusturalim.surekli overloading yapmak yerine
    public static <T> void printAllArray(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //sonuc donduren generic method
    public static <T> T getFirst(T[] arr){
        T first =arr[0];
        return first;
    }


    // birden fazla parametre ile generic method
    public static <T,U> void printArrAndObject(T[]arr,U object){
        //arr[0] = object; farkli turler oldugundan CTE verir
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println("========="+object);


    }

}
