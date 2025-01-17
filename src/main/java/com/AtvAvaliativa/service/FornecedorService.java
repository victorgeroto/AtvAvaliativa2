package com.AtvAvaliativa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AtvAvaliativa.entity.Fornecedor;
import com.AtvAvaliativa.repository.FornecedorRepository;

@Service
public class FornecedorService  {
	
private final FornecedorRepository fornecedorRepository;
	
	@Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }
	
	  public List<Fornecedor> getAllFornecedor() {
	        return fornecedorRepository.findAll();
	    }

	    public Fornecedor getFornecedorById(Long id) {
	        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
	        return fornecedor.orElse(null);
	    }

	    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
	        return fornecedorRepository.save(fornecedor);
	    }

	    public Fornecedor updatefornecedor(Long id, Fornecedor updatedFornecedor) {
	        Optional<Fornecedor> existingFornecedor = fornecedorRepository.findById(id);
	        if (existingFornecedor.isPresent()) {
	            updatedFornecedor.setId(id);
	            return fornecedorRepository.save(updatedFornecedor);
	        }
	        return null;
	    }

	    public boolean deleteFornecedor(Long id) {
	        Optional<Fornecedor> existingFornecedor = fornecedorRepository.findById(id);
	        if (existingFornecedor.isPresent()) {
	        	fornecedorRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	  
}


