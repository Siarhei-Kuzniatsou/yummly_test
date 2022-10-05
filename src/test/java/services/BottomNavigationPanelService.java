package services;

import pages.BottomNavigationPanel;

public class BottomNavigationPanelService {
    private static final BottomNavigationPanel panel = new BottomNavigationPanel();

    public static void goToSearch() {
        panel.getSearchButton().click();
    }
}
