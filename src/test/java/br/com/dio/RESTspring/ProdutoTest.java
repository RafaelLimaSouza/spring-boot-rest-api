package br.com.dio.RESTspring;

import br.com.dio.RESTspring.entity.Produto;
import br.com.dio.RESTspring.exception.ProductPriceException;
import br.com.dio.RESTspring.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void verificaValorNegativoProduto() throws Exception {
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(-10.0);

        assertThrows(ProductPriceException.class,() -> produtoService.save(produto));
    }
}
