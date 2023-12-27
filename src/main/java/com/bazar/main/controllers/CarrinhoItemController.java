package com.bazar.main.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bazar.main.models.CarrinhoItem;
import com.bazar.main.services.CarrinhoItemService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoItemController {
    @Autowired
    private CarrinhoItemService service;

    @GetMapping
    public ResponseEntity<List<CarrinhoItem>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoItem> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CarrinhoItem> create(@RequestBody CarrinhoItem obj) {
        CarrinhoItem carrinhoItem = service.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carrinhoItem.getId())
                .toUri();
        return ResponseEntity.created(uri).body(carrinhoItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoItem> atualizarSolicitacao(@PathVariable Long id, @RequestBody CarrinhoItem obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }
}
