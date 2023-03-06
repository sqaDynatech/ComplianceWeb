package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.touch.offset.ElementOption as ElementOption
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory



public class ManejoSTrings {


	@Keyword
	def String SeparaTexto(String textoCompleto, String separador, int lugarRetorna) {

		def elementos =textoCompleto.tokenize(separador)
		return elementos.get(lugarRetorna).toString()
	}


	@Keyword
	def String SeparaTextoRecObjeto(TestObject objeto, String separador, int lugarRetorna) {

		String textoCompleto = WebUI.getText(objeto)

		def elementos =textoCompleto.tokenize(separador)
		return elementos.get(lugarRetorna).toString()
	}

	@Keyword
	def ComparaTextoSeparado(TestObject objeto, String separador, String[] mensajes) {


		String textoCompleto = WebUI.getText(objeto)   //Lee el texto del objeto

		String elemento0 =textoCompleto.tokenize(0).toString()   //Lo separa en un array

		//Compara los elementos del texto leido con los elementos definidos en el array.
		if (elemento0==mensajes(0)) {
			KeywordUtil.markPassed("OK: Todos los mensajes están contenidos en la tabla")
		} else {
			KeywordUtil.markFailed("ERROR: No todos los mensajes están contenidos en la tabla")
		}
	}


}
