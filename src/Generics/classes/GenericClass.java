package Generics.classes;

//Syntax: public class GenericClass<T>

//Generics Primitive data tipleri ile kullanilmaz
public class GenericClass<T> {

    private T type;//her data tipini referans alabilen bir field olsuturduk

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
/*

   1- Kod Güvenliği ve Tip Kontrolleri: Genericler olmadan, Java koleksiyonları
    (örneğin ArrayList veya HashMap), her türden nesneyi depolayabilirdi.
     Bu, istenmeyen türleri koleksiyona ekleyerek potansiyel sorunlara yol açabilirdi.
     Genericler sayesinde koleksiyonlara hangi türdeki elemanların eklenebileceğini belirtebiliriz.
     Bu, derleme zamanında hataların tespit edilmesini sağlar

     2-Kod Yeniden Kullanılabilirliği ve Bakım Kolaylığı: Genericler, aynı kodu farklı veri türleriyle kullanma yeteneği sağlar.
      Bu, kodun daha esnek, tip güvenli ve bakımı kolay hale gelmesini sağlar.
 */