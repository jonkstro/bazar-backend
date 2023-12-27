package com.bazar.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazar.main.models.CarrinhoItem;
import com.bazar.main.repositories.CarrinhoItemRepository;
import com.bazar.main.services.exceptions.NotFoundException;

@Service
public class CarrinhoItemService {
    @Autowired
    private CarrinhoItemRepository repository;

    public List<CarrinhoItem> findAll() {
        return repository.findAll();
    }

    public CarrinhoItem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objeto de ID " + id + " não encontrado"));
    }

    public CarrinhoItem create(CarrinhoItem obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        CarrinhoItem carrinhoItem = findById(id);
        repository.deleteById(carrinhoItem.getId());
    }

    public CarrinhoItem update(Long id, CarrinhoItem obj) {
        CarrinhoItem newObj = findById(id);
        atualizarDados(obj, newObj);
        return repository.save(newObj);
    }

    private void atualizarDados(CarrinhoItem obj, CarrinhoItem newObj) {
        // Se o objeto que passei no PUT tiver vazio, faz nada
        if (obj.getNome() != null) {
            newObj.setNome(obj.getNome());
        }
        if (obj.getQuantidade() != null) {
            newObj.setQuantidade(obj.getQuantidade());
        }
        if (obj.getPreco() != null) {
            newObj.setPreco(obj.getPreco());
        }
    }

}
