package br.testes;

import br.pages.HomePage;
import br.pages.NovoCalculoPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class NovoCalculoTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver);
    }

    @Test
    public void deveAdicionarUmNovoCalculoEDeletar() {
        homePage.visita();
        homePage.novo().cadastraNovoCalculo("Fabio Bueno", "1", "40", "10");
        assertTrue(homePage.checkList("Fabio Bueno", "R$ 450,00", "R$ 411,75", "R$ 38,25", "R$ 0,00"));

        homePage.editar("Fabio Bueno").editaRegistro("Fabio Bueno 2", "1", "40", "10");
        assertTrue(homePage.checkList("Fabio Bueno 2", "R$ 450,00", "R$ 411,75", "R$ 38,25", "R$ 0,00"));

        homePage.deleteRegister("Fabio Bueno 2");
        assertFalse(homePage.checkList("Fabio Bueno 2", "R$ 450,00", "R$ 411,75", "R$ 38,25", "R$ 0,00"));
    }

    @After
    public void closePage(){
        driver.close();
    }
}
