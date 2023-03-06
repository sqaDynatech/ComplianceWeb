import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://192.168.2.231:8443/compliance_sqa/com.dynatechcompliance.login')

WebUI.setText(findTestObject('Object Repository/Page_Login/input_UserName'), 'admin')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login/input_Password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('Object Repository/Page_Login/input_BTNENTER'))

WebUI.setText(findTestObject('Object Repository/Page_Inicio/input_BuscadorMenu'), 'acumulado cliente')

WebUI.click(findTestObject('Object Repository/Page_Inicio/span_Monto Acumulado Cliente'))

WebUI.setText(findTestObject('Object Repository/Page_Monto Acumulado Clientes/input_Fecha Inicio_filtro'), '01/02/23')

WebUI.setText(findTestObject('Object Repository/Page_Monto Acumulado Clientes/input_Fecha Fin_filtro'), '28/02/23')

WebUI.click(findTestObject('Object Repository/Page_Monto Acumulado Clientes/input_Importe_filtro'))

WebUI.setText(findTestObject('Object Repository/Page_Monto Acumulado Clientes/input_Importe_filtro'), '1,00')

WebUI.click(findTestObject('Object Repository/Page_Monto Acumulado Clientes/input_boton_Buscar'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Monto Acumulado Clientes/span_Importe'), '7358,53')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Monto Acumulado Clientes/span_Cantidad'), '89')

WebUI.rightClick(findTestObject('Object Repository/Page_Monto Acumulado Clientes/IdCliente'))

