package br.com.dio.RESTspring.service;

import br.com.dio.RESTspring.entity.Produto;
import br.com.dio.RESTspring.exception.ProductNullException;
import br.com.dio.RESTspring.exception.ProductPriceException;
import br.com.dio.RESTspring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) throws ProductPriceException {

        if(produto.getNome() == null || produto.getPreco() == null)
            throw new ProductNullException();

        if(produto.getPreco() < 0)
            throw new ProductPriceException();
        return produtoRepository.save(produto);
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
}
