package br.com.dio.RESTspring.controller;

import br.com.dio.RESTspring.entity.Produto;
import br.com.dio.RESTspring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {
        return ResponseEntity.ok().body(produtoService.save(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Produto>> buscaTodosProdutos(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }
}
