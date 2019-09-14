package br.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visita() {
        driver.get("http://localhost:9098/");
    }

    public NovoCalculoPage novo() {
        driver.findElement(By.linkText("Novo Calculo")).click();
        return new NovoCalculoPage(driver);
    }

    public EditCalculoPage editar(String nome) {
        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > 0 && cells.get(0).getText().equals(nome)){
                row.findElement(By.cssSelector("td:nth-child(6) a")).click();
                return new EditCalculoPage(driver);
            }
        }

        return new EditCalculoPage(driver);
    }

    public void deleteRegister(String nome){
        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > 0 && cells.get(0).getText().equals(nome)){
                row.findElement(By.cssSelector("td:nth-child(7) a")).click();
                break;
            }
        }
    }

    public void editRegister(String nome){
        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > 0 && cells.get(0).getText().equals(nome)){
                row.findElement(By.cssSelector("td:nth-child(6) a")).click();
                break;
            }
        }
    }

    public boolean checkList(String nome, String salarioBruto, String salarioLiquido, String inss, String ir) {
        return driver.getPageSource().contains(nome) &&
                driver.getPageSource().contains(salarioBruto) &&
                driver.getPageSource().contains(salarioLiquido) &&
                driver.getPageSource().contains(inss) &&
                driver.getPageSource().contains(ir);
    }
}