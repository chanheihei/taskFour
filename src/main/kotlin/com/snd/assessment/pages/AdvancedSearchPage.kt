package com.snd.assessment.pages

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class AdvancedSearchPage(private val driver: WebDriver) {
    @FindBy(xpath = "//*[@id=\"global-search\"]")
    private lateinit var searchBox : WebElement

    @FindBy(xpath = "//*[@id=\"query\"]")
    private lateinit var focusedSearchBox : WebElement

    @FindBy(xpath = "//*[@id=\"all-words\"]")
    private lateinit var allWord : WebElement

    @FindBy(xpath = "//*[@id=\"exact-phrase\"]")
    private lateinit var exactPhrase : WebElement

    @FindBy(xpath = "//*[@id=\"least-words\"]")
    private lateinit var leastWords : WebElement

    @FindBy(xpath = "//*[@id=\"without-words\"]")
    private lateinit var withoutWords : WebElement

    @FindBy(xpath = "//*[@id=\"title-is\"]")
    private lateinit var titleIs : WebElement

    @FindBy(xpath = "//*[@id=\"author-is\"]")
    private lateinit var authorIs : WebElement

    @FindBy(xpath = "//*[@id=\"facet-start-year\"]")
    private lateinit var startYear: WebElement

    @FindBy(xpath = "//*[@id=\"facet-end-year\"]")
    private lateinit var endYear: WebElement

    @FindBy(xpath = "//*[@id=\"date-facet-mode\"]")
    private lateinit var yearDropDown: WebElement

    @FindBy(xpath = "//*[@id=\"results-only-access-checkbox-advanced\"]")
    private lateinit var includePreviewOnlyContentCheckBox: WebElement

    @FindBy(xpath = "//*[@id=\"submit-advanced-search\"]")
    private lateinit var submitAdvancedSearchButton: WebElement

    init {
        PageFactory.initElements(driver,this)
    }

    fun searchWithAllWordsWithEnter(query: String) {
        allWord.click()
        allWord.sendKeys(query, Keys.ENTER)
    }

    fun searchWithExactPhraseWithEnter(query: String) {
        exactPhrase.click()
        exactPhrase.sendKeys(query, Keys.ENTER)
    }

    fun searchWithLeastWordsWithEnter(query: String) {
        leastWords.click()
        leastWords.sendKeys(query, Keys.ENTER)
    }
}