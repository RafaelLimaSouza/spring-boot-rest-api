package br.com.dio.RESTspring.controller;

import br.com.dio.RESTspring.entity.Pedido;
import br.com.dio.RESTspring.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService  pedidoService;

    @PostMapping("/save")
    public ResponseEntity<Pedido> salvaPedido(@RequestBody Pedido pedido){

        return ResponseEntity.ok().body(pedidoService.save(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscaPedido(@PathVariable Long id){
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> buscaTodosPedidos(){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

}
