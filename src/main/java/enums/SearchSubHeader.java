package enums;

public enum SearchSubHeader {
    SELL ("Продают"),
    BUY ("Покупают"),
    HOSTING ("Сдают"),
    RENT ("Снимут"),
    CHANGE ("Меняют"),
    OTHER ("Разное"),
    SERVICE ("Услуги"),;

    private String name;

    SearchSubHeader(String name) {
        this.name = name;
    }
}
