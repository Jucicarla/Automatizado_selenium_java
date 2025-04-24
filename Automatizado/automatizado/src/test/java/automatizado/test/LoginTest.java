package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.LoginPO;

public class LoginTest extends BaseTest{
    private static LoginPO loginPage;
    
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }
    
    @Test
    public void TC001_naoDeveLogarNoSistemaComEmaileSenhaVazio(){
        loginPage.escrever(loginPage.inputEmail, "");
        loginPage.escrever(loginPage.inputSenha, "");
        loginPage.buttonEntrar.click();
        String mensagem = loginPage.obterMesangem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
        

    }
    @Test
    public void TC007_DeveLogarNoSistemaComEmaileSenhacorreto(){
        loginPage.excecutarAcaoDeLogar("admin@admin.com", "admin@123");
        //assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos";)
    }
}
