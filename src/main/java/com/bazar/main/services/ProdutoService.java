package com.bazar.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazar.main.models.Produto;
import com.bazar.main.repositories.ProdutoRepository;
import com.bazar.main.services.exceptions.NotFoundException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objeto de ID " + id + " não encontrado"));
    }

    public Produto create(Produto obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        Produto Produto = findById(id);
        repository.deleteById(Produto.getId());
    }

    public Produto update(Long id, Produto obj) {
        Produto newObj = findById(id);
        atualizarDados(obj, newObj);
        return repository.save(newObj);
    }

    private void atualizarDados(Produto obj, Produto newObj) {
        // Se o objeto que passei no PUT tiver vazio, faz nada
        if (obj.getNome() != null) {
            newObj.setNome(obj.getNome());
        }
        if (obj.getDescricao() != null) {
            newObj.setDescricao(obj.getDescricao());
        }
        if (obj.getPreco() != null) {
            newObj.setPreco(obj.getPreco());
        }
        if (obj.getImagemUrl() != null) {
            newObj.setImagemUrl(obj.getImagemUrl());
        }

    }
}
