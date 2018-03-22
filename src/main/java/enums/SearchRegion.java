package enums;

public enum SearchRegion {

    RIGA_F ("Рига"),
    YURMALA_F ("Юрмала"),
    RIGA_REGION_F ("Рижский р-он"),
    AIZKRAUKLE_F ("Айзкраукле и р-он"),
    ALUKSNE_F ("Алуксне и р-он"),
    BALVI_F ("Балви и р-он"),
    BAUSKA_F ("Бауска и р-он"),
    VALKA_F ("Валка и р-он"),
    VALMIERA_F ("Валмиера и р-он"),
    VENTSPILS_F ("Вентспилс и р-он"),
    GULBENE_F ("Гулбене и р-он"),
    DAUGAVPILS_F ("Даугавпилс и р-он"),
    DOBELE_F ("Добеле и р-он"),
    JEKABPILS_F ("Екабпилс и р-он"),
    JELGAVA_F ("Елгава и р-он"),
    KRASLAVA_F ("Краславa и р-он"),
    KULDIGA_F ("Кулдига и р-он"),
    LIEPAJA_F ("Лиепая и р-он"),
    LIMBADZI_F ("Лимбажи и р-он"),
    LUDZA_F ("Лудза и р-он"),
    MADONA_F ("Мадона и р-он"),
    OGRE_F ("Огре и р-он"),
    PREILI_F ("Прейли и р-он"),
    REZEKNE_F ("Резекне и р-он"),
    SALDUS_F ("Салдус и р-он"),
    TALSI_F ("Талси и р-он"),
    TUKUMS_F ("Тукумс и р-он"),
    CESIS_F ("Цесис и р-он"),
    LITHUANIA_F ("Литва"),
    ESTONIA_F ("Эстония"),;


    SearchRegion(String regionName) {
        this.regionName = regionName;
    }
    private String regionName;
}
