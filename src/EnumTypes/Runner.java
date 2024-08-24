package EnumTypes;

public class Runner {
    public static void main(String[] args) {
        useConstant("OTHER");
        useConstant("PAYMENT");
        useConstant("EFT");//CTE vermiyor.ama ENUM kullanirsak hatayi aliriz

        //sadece sinirli ve sabit degiskenlker kullanabilmek icin ENUM type kullanmaliyiz.


        System.out.println("****ENUM******");
        useEnumTypes(TransactionTypeEnum.PAYMENT);
        useEnumTypes(TransactionTypeEnum.OTHER);
        //useEnumTypes(TransactionTypeEnum.EFT); BURADA EFT enumda oldugu icin hatayi hemen gosterdi


    }

    public static void useConstant(String secim){
        if (secim==TransactionTypeConstant.DEPOSIT){
            System.out.println("para yatirildi");
        } else if (secim==TransactionTypeConstant.WITHDRAW) {
            System.out.println("para cekildi");
        } else if (secim==TransactionTypeConstant.PAYMENT) {
            System.out.println("odeme yapildi");
        } else if (secim==TransactionTypeConstant.TRANSFER) {
            System.out.println("transfer yapildi");
        }else {
            System.out.println("diger islemler");
        }
    }

    //ayni metodu Enum  kullanarak yapalim

    public static void useEnumTypes(TransactionTypeEnum secim){
        if (secim==TransactionTypeEnum.DEPOSIT){
            System.out.println("para yatirildi");
        } else if (secim==TransactionTypeEnum.WITHDRAW) {
            System.out.println("para cekildi");
        } else if (secim==TransactionTypeEnum.PAYMENT) {
            System.out.println("odeme yapildi");
        } else if (secim==TransactionTypeEnum.TRANSFER) {
            System.out.println("transfer yapildi");
        }else {
            System.out.println("diger islemler");
        }
        if (secim.getCode()==10){
            System.out.println("para yatirildi");
        } else if (secim.getCode()==20) {
            System.out.println("para cekildi");
        }

        System.out.println("Enum ismi:"+ secim.name());//ENum Ismini boyle alabiliriz
        System.out.println("Enum ordinal number "+secim.ordinal());//ordinal number yani index numberi


    }



}
