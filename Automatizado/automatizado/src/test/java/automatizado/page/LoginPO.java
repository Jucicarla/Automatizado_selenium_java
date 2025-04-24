package automatizado.page;

import java.security.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    @FindBy(id ="email")
    public WebElement inputEmail;

    @FindBy(id="senha")
    public WebElement inputSenha;

    @FindBy(id="btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css="form.form-login>div.alert>spam")
    public WebElement spamMensagem;

    public LoginPO(WebDriver driver){
        super(driver);
    }
    public String obterMesangem(){
        return spamMensagem.getText();
    }
    
    public void excecutarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();

    }
    
}
