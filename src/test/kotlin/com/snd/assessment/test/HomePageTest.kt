package com.snd.assessment.test

import com.snd.assessment.pages.HomePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import kotlin.test.assertTrue

class HomePageTest {
    private lateinit var driver: WebDriver
    private lateinit var homePage: HomePage

    @BeforeTest
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers/chromedriver.exe")
        driver = ChromeDriver()
        driver?.manage()?.window()?.maximize()
        homePage = HomePage(driver)
    }

    @Test
    fun searchForArticleWithSearchButton() {
        homePage.open()
        homePage.searchWithSearchButton("Chemistry")
        assertTrue(driver.currentUrl == "https://rd.springer.com/search?query=Chemistry")
    }

    @Test
    fun searchForArticleWithEnter() {
        homePage.open()
        homePage.searchWithEnter("Biology")
        assertTrue(driver.currentUrl == "https://rd.springer.com/search?query=Biology")
    }

    @Test
    fun searchForArticleWithSuggestion() {
        homePage.open()
        homePage.searchWithSuggestionTest("Physics")
        Thread.sleep(6000)
        assertTrue(driver.currentUrl == "https://rd.springer.com/search?query=EPJ+Nonlinear+Biomedical+Physics")
    }

    @Test
    fun searchForAllArticles() {
        homePage.open()
        homePage.searchWithoutQuery()
        assertTrue(driver.currentUrl == "https://rd.springer.com/search?query=")
    }

    @Test
    fun openAdvancedSearchPage() {
        homePage.open()
        homePage.openSearchOptions()
        homePage.openAdvancedSearchLink()
        assertTrue(driver.currentUrl == "https://rd.springer.com/advanced-search")
    }

    @AfterTest
    fun tearDown() {
        driver?.close()
    }
}