package Serialization;

import java.io.*;

//OUS objeleri serilestirerek,Java objelerini kodlar ve byte akisina yazdirir.
public class Serialization_Deserialization {

    public static void main(String[] args) {

        writeObjects();
        readObjects();

    }

    public static void writeObjects(){
        System.out.println("Objeler olusturuluyor.");
        User user1 = new User(1,"yavuz",32);
        User user2 = new User(2,"ali",28);
        User user3 = new User(3,"hakan",28);

        // nesnelerin yazildigi dosyayi olustrumak icin
        try {
            // FOS javada dosyaya veri yazmamizi saglar
            //  NESNELERIN YAZILDIGI dosyayi veri yazmamizi saglar
            FileOutputStream fos = new FileOutputStream("user.ser");
            //objeleri yazdirmak icin
            //objelerin yazilabilmesi icin serialization gerekli
            try {
                ObjectOutputStream output = new ObjectOutputStream(fos);
                output.writeObject(user1);
                output.writeObject(user2);
                output.writeObject(user3);

                output.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public  static void readObjects(){
        //javada dosyadakileri okuma islemlerinde FIS kullanilir
        try {
            FileInputStream fis = new FileInputStream("user.ser");
            //objelerin de-seralization okumasi icin OIS
            try {
                ObjectInputStream input = new ObjectInputStream(fis);

                User user1 = (User) input.readObject();
                User user2 = (User) input.readObject();
                User user3 = (User) input.readObject();
                //readObject dosyanin sonuna geldiginde EOFException firlatir.

                System.out.println(user1);
                System.out.println(user2);
                System.out.println(user3);

                input.close();
                fis.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
