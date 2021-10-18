package br.com.tech4me.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.ecommerce.model.Produto;
import br.com.tech4me.ecommerce.repository.ProdutoRepository;
import br.com.tech4me.ecommerce.shared.ProdutoDto;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repositorio;

    public ProdutoDto criarProduto(ProdutoDto dto) {
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(dto, Produto.class);
        produto = repositorio.save(produto);

        return mapper.map(produto, ProdutoDto.class);
    }

    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repositorio.findAll();

        return produtos.stream()
            .map(p -> new ModelMapper().map(p, ProdutoDto.class))
            .collect(Collectors.toList());
    }

    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repositorio.findById(id);

        
        if(produto.isPresent()) {
            ProdutoDto dto = new ModelMapper().map(produto.get(), ProdutoDto.class);
            return Optional.of(dto);
        }
 
        return Optional.empty();
    }

    public ProdutoDto atualizarProduto(String id, ProdutoDto dto) {
        return null;
    }

    public void removerProduto(String id) {
    }
    
}
