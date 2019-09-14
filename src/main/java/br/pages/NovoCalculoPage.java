package br.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoCalculoPage {

    private WebDriver driver;

    public NovoCalculoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cadastraNovoCalculo(String nome, String dependentes, String timeToWork, String salaryHour) {
        WebElement inputNome = driver.findElement(By.name("name"));
        WebElement inputDependentes = driver.findElement(By.name("dependents"));
        WebElement inputTimeToWork = driver.findElement(By.name("timeToWork"));
        WebElement inputSalaryHour = driver.findElement(By.name("salaryHour"));

        inputNome.clear();
        inputNome.sendKeys(nome);

        inputDependentes.clear();
        inputDependentes.sendKeys(dependentes);

        inputTimeToWork.clear();
        inputTimeToWork.sendKeys(timeToWork);

        inputSalaryHour.clear();
        inputSalaryHour.sendKeys(salaryHour);

        inputNome.submit();
    }
}
