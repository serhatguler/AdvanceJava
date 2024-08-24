package EnumTypes;

//degerli sabit ve sinirli sayida deger varsa ENUM kullan
public enum TransactionTypeEnum {

    DEPOSIT(10),//0:ordinal(index number)
    WITHDRAW(20),//1
    TRANSFER(30),//2
    PAYMENT(40),//3
    OTHER(100);//4

    // ENUMLAR DEFAULTTA STATIC VE FINALDIR.


    private final int code;//field ekledik enuma

    public int getCode() {
        return code;
    }

    TransactionTypeEnum(int code) { //CONSTRUCTOR PRIVATETIR
        this.code = code;
    }



}
