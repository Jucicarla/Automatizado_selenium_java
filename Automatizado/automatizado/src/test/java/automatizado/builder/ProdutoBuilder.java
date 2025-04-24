 package automatizado.builder;

import org.openqa.selenium.WebDriver;

import automatizado.page.ControleProdutoPO;
import automatizado.test.ControleDeProdutoTest;

public class ProdutoBuilder {
    public String codigo = "001";
    public String nome = "Produto padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "24/04/2025";
    private ControleProdutoPO controleProdutoPO;
    public ProdutoBuilder(ControleProdutoPO controleProdutoPO){
        this.controleProdutoPO = controleProdutoPO;
    }

    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo =  codigo;
        return this;
    }
    public ProdutoBuilder adicionarNome(String nome){
        this.nome =  nome;
        return this;
    }
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade =  quantidade;
        return this;
    }
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor =  valor;
        return this;
    }
    public ProdutoBuilder adicionarDatao(String data){
        this.data =  data;
        return this;
    }

    public void builder(){
    
        controleProdutoPO.escrever(controleProdutoPO.inputCodigo, codigo);
        controleProdutoPO.escrever(controleProdutoPO.inputNome, nome);
        controleProdutoPO.escrever(controleProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString():"");
        controleProdutoPO.escrever(controleProdutoPO.inputValor, (valor != null) ? valor.toString():"");
        controleProdutoPO.escrever(controleProdutoPO.inputData, data);

        controleProdutoPO.buttonSalvar.click();
        
    }

    

    
}