package custom
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.persistence.metamodel.ListAttribute

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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


class ManejoDeMensajes {

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	def List<WebElement> obtenerListaMensajes(TestObject contenedorMensajes) {
		WebElement contenedor = WebUiBuiltInKeywords.findWebElement(contenedorMensajes)
		List<WebElement> mensajes = contenedor.findElements(By.xpath("./div"))
		return mensajes
	}


	@Keyword
	def void verificarCantidadMensajes(TestObject contenedor, int cantidad) {
		WebUI.waitForElementPresent(contenedor, 0)
		WebUI.waitForElementVisible(contenedor, 0)
		ArrayList<WebElement> lista = obtenerListaMensajes(contenedor)
		WebUI.verifyEqual(lista.size(), cantidad)
	}

	def List<WebElement> columna(TestObject contenedorMensajes) {
		WebElement contenedor = WebUiBuiltInKeywords.findWebElement(contenedorMensajes)
		List<WebElement> mensajes = contenedor.findElements(By.xpath("./div"))
		return mensajes
	}

	@Keyword
	def void LecturaMensajesErrorToast() {
		List<WebElement> mensajes = driver.findElements(By.xpath("/html/body/div[9]/div/div"));
		for(WebElement msd : mensajes ) {
			if(msd.getText().isEmpty()==false) {
				System.out.println(msd.getText());
				System.out.println("Size--" + mensajes.size());
			}
		}
	}
}