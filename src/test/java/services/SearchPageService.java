package services;

import pages.SearchPage;

public class SearchPageService extends BottomNavigationPanelService {
    private final static SearchPage searchPage = new SearchPage();

    public static void search(String value) {
        searchPage.getSearchField().clear();
        searchPage.getSearchField().click();
        searchPage.getSearchField().sendKeys(value);
        MobileActions.clickSearchButtonFromKeyboard();
    }

    public static void chooseFirstSearchResult() {
        searchPage.getSearchResults().get(0).click();
    }
}
