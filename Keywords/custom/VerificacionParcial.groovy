package custom
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows




class VerificacionParcial {

	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */

	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	def containsText(String actualText, String expectedText) {
		KeywordUtil.logInfo("Analizando contains")
		if (actualText.contains(expectedText)) {
			KeywordUtil.markPassed("OK: El texto está contenido")
		} else {
			KeywordUtil.markFailed("ERROR: El texto "+ expectedText + " no esta contenido en " + actualText)
		}
	}

	@Keyword
	def void containsTextInObject(TestObject contenedoractualText, String expectedText) {
		def actualText= WebUI.getText(contenedoractualText)

		KeywordUtil.logInfo("Analizando contains")

		if (actualText.contains(expectedText)) {
			KeywordUtil.markPassed("OK: El texto está contenido")
		} else {
			KeywordUtil.markFailed("ERROR: El texto "+ expectedText + " no esta contenido en " + actualText)
		}
	}

	@Keyword
	def containsTextList(ArrayList<String> textList, String expectedText) {
		boolean res = false
		for (text in textList) {
			if (expectedText.contains(text)) {
				res = true
			}
		}
		if (!res) {
			KeywordUtil.markFailed("ERROR: El texto "+ expectedText + " no esta contenido en la lista")
		} else {
			KeywordUtil.markPassed("OK: El texto "+ expectedText + " esta contenido en la lista")
		}
	}

	@Keyword
	def equalTextList(ArrayList<String> ListTextPosibles, String expectedText) {
		'Verifica si el texto del elemento contiene alguno de los textos de la lista'
		boolean encuentra = false
		for (text in ListTextPosibles) {
			if (expectedText.equals(text)) {
				encuentra = true
				break
			}
		}
		if (!encuentra) {
			KeywordUtil.markFailed("ERROR: El texto "+ expectedText + " no esta contenido en la lista")
		} else {
			KeywordUtil.markPassed("OK: El texto "+ expectedText + " esta contenido en la lista")
		}
	}


	@Keyword
	def obtenerNroGiroPorURL(String URL) {
		def aux = URL.tokenize('?')
		return aux.get(aux.size()-1).toString()
	}
}