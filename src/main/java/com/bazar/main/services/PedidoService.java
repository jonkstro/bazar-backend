package com.bazar.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazar.main.models.Pedido;
import com.bazar.main.repositories.PedidoRepository;
import com.bazar.main.services.exceptions.NotFoundException;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objeto de ID " + id + " não encontrado"));
    }

    public Pedido create(Pedido obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        Pedido Pedido = findById(id);
        repository.deleteById(Pedido.getId());
    }

    public Pedido update(Long id, Pedido obj) {
        Pedido newObj = findById(id);
        atualizarDados(obj, newObj);
        return repository.save(newObj);
    }

    private void atualizarDados(Pedido obj, Pedido newObj) {
        // Se o objeto que passei no PUT tiver vazio, faz nada
        if (obj.getData() != null) {
            newObj.setData(obj.getData());
        }
        if (obj.getTotal() != null) {
            newObj.setTotal(obj.getTotal());
        }
    }
}
