package com.yummly.services;

import com.yummly.pages.WelcomePage;

public class WelcomePageService {
    private static final WelcomePage welcomePage = new WelcomePage();

    public static void skipToTryYummlyWithoutPersonalization() {
        welcomePage.getSkipToTryYummlyWithoutPersonalization().click();
    }
}