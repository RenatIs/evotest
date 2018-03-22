package webpages;

import enums.SearchRegion;


public class Ad implements Comparable{
    private Integer id;
    private String data;
    private String price;

    public Ad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        return getId() != null ? getId().equals(ad.getId()) : ad.getId() == null;
    }

    public int compareTo(Object ad) {
        int compareId=((Ad)ad).getId();
        return this.id-compareId;
    }

}
