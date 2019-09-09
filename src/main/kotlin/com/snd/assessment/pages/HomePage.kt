package com.snd.assessment.pages

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class HomePage(private val driver: WebDriver) {
    @FindBy(xpath = "//*[@id=\"global-search\"]/div[1]")
    private lateinit var searchBox: WebElement

    @FindBy(xpath = "//*[@id=\"query\"]")
    private lateinit var focusedSearchBox: WebElement

    @FindBy(xpath = "//*[@id=\"search\"]")
    private lateinit var searchButton: WebElement

    @FindBy(xpath = "//*[@id=\"search-options\"]/button")
    private lateinit var searchOptionsButton: WebElement

    @FindBy(xpath = "//*[@id=\"advanced-search-link\"]")
    private lateinit var advancedSearchLink: WebElement

    init {
        PageFactory.initElements(driver,this)
    }

    fun open() {
        driver.get("https://rd.springer.com")
    }

    fun openSearchOptions() {
        searchOptionsButton?.click()
    }

    fun openAdvancedSearchLink() {
        advancedSearchLink?.click()
    }

    fun searchWithSearchButton(query: String) {
        searchBox?.click()
        focusedSearchBox?.sendKeys(query)
        searchButton?.click()
    }

    fun searchWithEnter(query: String) {
        searchBox?.click()
        focusedSearchBox?.sendKeys(query, Keys.ENTER)
    }

    fun searchWithSuggestionTest(query: String) {
        searchBox?.click()
        focusedSearchBox?.sendKeys(query)
        Thread.sleep(3000)
        val list = driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li"))
        println("Total no of suggestions in search box::" + list.size)
        for (i in list.indices) {
            println(list[i])
            if (list[i].text.contains(query)) {
                list[i].click()
                break
            }
        }
    }

    fun searchWithoutQuery() {
        searchButton?.click()
    }
}