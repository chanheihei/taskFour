package com.snd.assessment.test

import com.snd.assessment.pages.HomePage
import com.snd.assessment.pages.SearchPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import kotlin.test.assertTrue

class SearchPageTest {
    private lateinit var driver: WebDriver
    private lateinit var homePage: HomePage
    private lateinit var searchPage: SearchPage

    @BeforeTest
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers/chromedriver.exe")
        driver = ChromeDriver()
        driver?.manage()?.window()?.maximize()
        homePage = HomePage(driver)
        searchPage = SearchPage(driver)
    }

    @Test
    fun clearSearch() {
        homePage.open()
        homePage.searchWithEnter("Test")
        searchPage.open()
        searchPage.clearSearchQuery()
        assertTrue(driver.currentUrl == "https://link.springer.com/search")
    }

    @Test
    fun selectFirstSearchResult() {
        homePage.open()
        homePage.searchWithoutQuery()
        searchPage.selectFirstResult()
    }

    @AfterTest
    fun tearDown() {
        driver?.close()
    }
}