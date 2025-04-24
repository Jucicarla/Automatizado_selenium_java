package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO{
    /*Driver base  que será usado pelas pages */
    protected WebDriver driver;
    /*
     * Construtor base para criação de fabrica de elementos (PageFactory)
     */

    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Método que retorna o titulo da página atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }
    /**
     * Método que sabe escrever em qualquer Webelement do tipo input e dar um TAB ao final
     * @param input
     * @param texto
     */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto+ Keys.TAB);
    }


}