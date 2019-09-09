package com.snd.assessment.test

import com.snd.assessment.pages.AdvancedSearchPage
import com.snd.assessment.pages.HomePage
import junit.framework.Assert.assertTrue
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class AdvancedSearchPageTest {
    private lateinit var driver: WebDriver
    private lateinit var homePage: HomePage
    private lateinit var advancedSearchPage: AdvancedSearchPage

    @BeforeTest
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers/chromedriver.exe")
        driver = ChromeDriver()
        driver?.manage()?.window()?.maximize()
        homePage = HomePage(driver)
        advancedSearchPage = AdvancedSearchPage(driver)
    }

    @Test
    fun advancedSearchWithAllWordsWithEnter() {
        homePage.open()
        homePage.openSearchOptions()
        homePage.openAdvancedSearchLink()
        advancedSearchPage.searchWithAllWordsWithEnter("Chemical Engineering")
        Thread.sleep(2000)
        assertTrue(driver.currentUrl == "https://rd.springer.com/search?query=Chemical+AND+Engineering&date-facet-mode=between&showAll=true#")
    }

    @Test
    fun advancedSearchWithExactPhraseWithEnter() {
        homePage.open()
        homePage.openSearchOptions()
        homePage.openAdvancedSearchLink()
        advancedSearchPage.searchWithExactPhraseWithEnter("sports science")
        Thread.sleep(2000)
        assertTrue(driver.currentUrl == "https://rd.springer.com/search?query=%22sports+science%22&date-facet-mode=between&showAll=true#")
    }

    @Test
    fun advancedSearchWithLeastWordsWithEnter() {
        homePage.open()
        homePage.openSearchOptions()
        homePage.openAdvancedSearchLink()
        advancedSearchPage.searchWithLeastWordsWithEnter("Physics Chemistry Physics")
        Thread.sleep(2000)
    }

    @AfterTest
    fun tearDown() {
        driver?.close()
    }
}