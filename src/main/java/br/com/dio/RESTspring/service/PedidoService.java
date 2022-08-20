package br.com.dio.RESTspring.service;

import br.com.dio.RESTspring.entity.Pedido;
import br.com.dio.RESTspring.entity.Produto;
import br.com.dio.RESTspring.repository.PedidoRepository;
import br.com.dio.RESTspring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(Pedido pedido){
        Set<Produto> produtos = new HashSet<>();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.getProdutos().forEach(produto -> {
            produtos.add(produtoRepository.getById(produto.getId()));
        });
        pedido.setProdutos(produtos);

        return pedidoRepository.save(pedido);
    }

    public Pedido findById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

}
