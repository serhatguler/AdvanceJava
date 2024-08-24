package Generics.bounding;
//parametre olarak aldigimiz data tipini sinirlayabiliriz
//T burada number extend etti yani integer long double... olur .sinirladik
public class GenericUpperBound<T extends Number> {
    private T[] numberArray;//field ozelligi


    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //array icindeki degerlerin ortalamasi icin bulan method olusturalim
    public double getAverage(){
        double sum =0;

        for (T t:numberArray) {
            sum = sum+t.doubleValue(); //t yi double a cevir ve sum a ekle
        }

        double avg = sum/this.numberArray.length;
        return avg;
    }

    //==========    main===========
    public static void main(String[] args) {
        Integer[] intArr ={2,4,5,6,10};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAverage());

        Double[] doubles = {2.3,3.5,6.8};
        GenericUpperBound<Double> obj2= new GenericUpperBound<>(doubles);
        System.out.println(obj2.getAverage());

//        String[] strings ={"java","generics"};
//        GenericUpperBound<String> obj3 = new GenericUpperBound<String>();
//        Burada string yapamayiz T data tipini number ile sinirlandirdik
    }

}
