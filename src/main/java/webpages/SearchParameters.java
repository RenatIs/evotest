package webpages;

import enums.SearchPeriod;
import enums.SearchRegion;
import enums.SearchSubHeader;

public class SearchParameters {
    private static SearchParameters searchParameters;
    private String keyphrase;
    private String minPrice;
    private String maxPrice;
    private SearchSubHeader searchSubHeader;
    private SearchPeriod searchPeriod;
    private SearchRegion searchRegion;

    private SearchParameters() {
    }

    public static SearchParameters create() {
        searchParameters = new SearchParameters();
        return searchParameters;
    }

    public static SearchParameters getSearchParameters() {
        return searchParameters;
    }

    public SearchParameters withKeyPhrase(String keyphrase) {
        searchParameters.keyphrase = keyphrase;
        return searchParameters;
    }

    public SearchParameters withMinPrice(String minPrice) {
        searchParameters.minPrice = minPrice;
        return searchParameters;
    }

    public SearchParameters withMaxPrice(String maxPrice) {
        searchParameters.maxPrice = maxPrice;
        return searchParameters;
    }

    public SearchParameters withSubHeader(SearchSubHeader searchSubHeader) {
        searchParameters.searchSubHeader = searchSubHeader;
        return searchParameters;
    }

    public SearchParameters withSearchRegion(SearchRegion searchRegion) {
        searchParameters.searchRegion = searchRegion;
        return searchParameters;
    }

    public SearchParameters withSearchPeriod(SearchPeriod searchPeriod) {
        searchParameters.searchPeriod = searchPeriod;
        return searchParameters;
    }

    public String getKeyphrase() {
        return keyphrase;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public SearchSubHeader getSearchSubHeader() {
        return searchSubHeader;
    }

    public SearchPeriod getSearchPeriod() {
        return searchPeriod;
    }

    public SearchRegion getSearchRegion() {
        return searchRegion;
    }
}
