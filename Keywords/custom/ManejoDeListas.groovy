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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver

class ManejoDeListas {
	WebDriver driver = DriverFactory.getWebDriver()
	/**
	 * Seleccionar el elemento en listas que NO son selects
	 */
	@Keyword
	def seleccionarElemento(TestObject elemPadre, TestObject elemHijo) {
		WebUI.click(elemPadre)

		WebUI.click(elemHijo)
	}

	@Keyword
	def seleccionarElementoListaLi(TestObject campoPais, TestObject campoEditable, String textoBUscado,TestObject elementoSeleccionado ) {
		WebUI.click(campoPais)
		WebUI.sendKeys(campoEditable, textoBUscado)
		WebUI.click(elementoSeleccionado)
	}

	@Keyword
	def actions(String tipoDoc) {
		WebElement buttonTipoDoc = driver.findElement(By.id("COMBO_COUNTERPARTDOCUMENTCOUNTRYContainer_btnGroupDrop"));
		buttonTipoDoc.click();
		buttonTipoDoc.findElement(By.xpath("//*[@id='COMBO_COUNTERPARTDOCUMENTCOUNTRYContainer']/ul/li[1]/div/div/div/input")).sendKeys(tipoDoc);
		driver.findElement(By.xpath("//span[contains(text(),'" + tipoDoc + "' )]")).click();
	}

	@Keyword
	def evaluarFuenteDeElementos(String Fuentes, String Size, String xpath){

		WebDriver driver = DriverFactory.getWebDriver()

		/*TestObject myTestObject = findTestObject('findTestObject(Object Repository/Page_Enviar Giro/Crear Cotización/etiquetasss')
		 def listaDeFuentes = WebUI.findWebElements(myTestObject)*/

		List listaDeFuentes = driver.findElements(By.xpath(xpath))
		println(listaDeFuentes.size())

		def elementos_con_FuenteFamily_noEsperada = []
		def elementos_con_FuenteSize_noEsperada = []

		for (WebElement elemento : listaDeFuentes){

			String fuent_family = elemento.getCssValue('font-family')
			String font_size= elemento.getCssValue('font-size')
			// println(font_size)


			if(!fuent_family.contains(Fuentes)){
				elementos_con_FuenteFamily_noEsperada.add(element.getText())
			}

			if(!font_size.toString().equals(Size)){
				elementos_con_FuenteSize_noEsperada.add(element.getText())
			}
		}

		if(!elementos_con_FuenteFamily_noEsperada.isEmpty()){
			KeywordUtil.markFailed( "La fuente de los siguientes elementos no es" +Fuentes+". Elementos que tienen erroe:"  + elementos_con_FuenteFamily_noEsperada, FailureHandling.CONTINUE_ON_FAILURE)

		}else if(!elementos_con_FuenteSize_noEsperada.isEmpty()) {
			KeywordUtil.markFailed( "El tamaño de fuente de los siguientes elementos no es" + Size+". Elementos que tienen error:" + elementos_con_FuenteSize_noEsperada, FailureHandling.CONTINUE_ON_FAILURE)

		}else {
			KeywordUtil.markPassed("test passed")
		}
	}

	@Keyword
	def  clickElementoTablaWeb(){
		List columna = driver.findElements(By.xpath("//*[@data-colindex='2']"))
		println(columna.size())

	}


}