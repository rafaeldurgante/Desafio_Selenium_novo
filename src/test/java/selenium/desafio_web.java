package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Teste Automatizado do Desafio Web do Sicredi")

public class desafio_web {

  @Test
  @DisplayName("Incluir um novo cliente no sistema")

  public void testIncluirUmNovoClienteNoSistema () throws InterruptedException {
      //Vou abrir o Chrome com o site
      WebDriverManager.chromedriver().setup();
      WebDriver navegador = new ChromeDriver();
      //navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
      navegador.get("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");
      navegador.manage().window().setSize(new Dimension(1382, 744));
      {
          WebElement dropdown = navegador.findElement(By.id("switch-version-select"));
          dropdown.findElement(By.xpath("//option[. = 'Bootstrap V4 Theme']")).click();
      }
      navegador.findElement(By.linkText("Add Customer")).click();
      navegador.findElement(By.id("field-customerName")).click();
      navegador.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
      navegador.findElement(By.id("field-contactLastName")).sendKeys("Teste");
      navegador.findElement(By.id("field-contactFirstName")).sendKeys("Rafael");
      navegador.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
      navegador.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
      navegador.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
      navegador.findElement(By.id("field-city")).sendKeys("Porto Alegre");
      navegador.findElement(By.id("field-state")).sendKeys("RS");
      navegador.findElement(By.id("field-postalCode")).sendKeys("91000-000");
      navegador.findElement(By.id("field-country")).sendKeys("Brasil");
      navegador.findElement(By.cssSelector("span")).click();
      navegador.findElement(By.cssSelector(".chosen-search > input")).sendKeys("Fixter");
      navegador.findElement(By.cssSelector("em")).click();
      navegador.findElement(By.id("field-creditLimit")).click();
      navegador.findElement(By.id("field-creditLimit")).sendKeys("200");
      navegador.findElement(By.id("form-button-save")).click();

      //Validação a mensagem de sucesso ao cadastrar o cliente:
      Thread.sleep(3000);
      String mensagemsucesso = navegador.findElement(By.xpath("//*[@id=\"report-success\"]/p")).getText();
      Assertions.assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", mensagemsucesso);
      navegador.close();
    }
}
