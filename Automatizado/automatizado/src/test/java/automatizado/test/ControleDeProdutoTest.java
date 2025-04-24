 package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleProdutoPO;
import automatizado.page.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
 public class ControleDeProdutoTest extends BaseTest{
    private static LoginPO loginPage;
    private static ControleProdutoPO controleProdutoPage;
    
    @BeforeClass
    public static void prepararTestes(){
        loginPage =new LoginPO(driver);        
        loginPage.excecutarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(),"Controle de Produtos");
    }
    @Test
    public void TC001_deveAbrirModalCadastroaoClicarNoBotaoCriar(){
        //TODO remover esse click assim que o sistema for corrigido 
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto",titulo);
        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }
   // @Test
   // public void TC002_naodevecadastrarUmProdutoSemPreencherTodosOsCampos(){
//   controleProdutoPage.buttonAdicionar.click();
//        controleProdutoPage.buttonAdicionar.click();
//        
//        controleProdutoPage.cadastrarProduto("0001", "Folha", 10.9, 3, "");
//        String mensagem = controleProdutoPage.spamMensagem.getText();
//        assertEquals("Todos os campos são obrigatório para o cadastro", mensagem);
      
//    }
    @Test
    public void TC003_naodevecadastrarUmProdutoSemPreencherTodosOsCampos(){
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        //Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        //aqui realmente ele adiciona na tela
        //aqui estamos testando se o produto é adicionado sem codigo
        produtoBuilder
        .adicionarCodigo("")
        .builder();  
        assertEquals(mensagem ,controleProdutoPage.spamMensagem.getText());

        produtoBuilder
        .adicionarCodigo("002")
        .adicionarQuantidade(null)
        .builder();  
        assertEquals(mensagem ,controleProdutoPage.spamMensagem.getText());

        
        produtoBuilder
        .adicionarValor(null)
        .builder(); 
        assertEquals(mensagem ,controleProdutoPage.spamMensagem.getText());

        produtoBuilder
        .adicionarValor(50.0)
        .adicionarData(null)
        .builder(); 
        assertEquals(mensagem ,controleProdutoPage.spamMensagem.getText());

        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();


       
        
    }


    
}