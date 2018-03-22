package enums;

public enum SearchPeriod {
    FOR_TODAY ("Среди сегодняшних объявлений"),
    FOR_LAST_3_DAYS ("За последних 3 дня"),
    FOR_WEEK ("За последнюю неделю"),
    FOR_MONTH ("За последний месяц"),
    FOR_ALL ("Среди всех объявлений"),;

    private String period;

    SearchPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }
}
