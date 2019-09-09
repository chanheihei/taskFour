package com.snd.assessment.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SearchPage(private val driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"number-of-search-results-and-search-terms\"]")
    private lateinit var numberOfResults: WebElement

    @FindBy(xpath = "//*[@id=\"results-list\"]")
    private lateinit var articles: List<WebElement>

    @FindBy(xpath = "/html/body/div[4]/div[3]/div[2]/main/ol/li[1]/h2/a")
    private lateinit var firstResult: WebElement

    @FindBy(xpath = "//*[@id=\"global-search-new\"]")
    private lateinit var clearSearch: WebElement

    init {
        PageFactory.initElements(driver,this)
    }

    fun open() {
        driver.get("https://link.springer.com/search?query=Test")
    }

    fun selectFirstResult() {
        firstResult?.click()
    }

    fun clearSearchQuery() {
        clearSearch?.click()
    }
}