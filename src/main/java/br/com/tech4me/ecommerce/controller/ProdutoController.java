package br.com.tech4me.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.ecommerce.service.ProdutoService;
import br.com.tech4me.ecommerce.shared.ProdutoDto;
import br.com.tech4me.ecommerce.shared.ProdutoModeloRequest;
import br.com.tech4me.ecommerce.shared.ProdutoModeloResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    private ModelMapper mapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<ProdutoModeloResponse> criarProduto(@RequestBody @Valid ProdutoModeloRequest produto) {
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.criarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos() {
        List<ProdutoDto> dto = service.obterTodos();

        if(dto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<ProdutoModeloResponse> resp = dto.stream()
                    .map(d -> mapper.map(d, ProdutoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<ProdutoModeloResponse> obterPorId(@PathVariable String id) {
        Optional<ProdutoDto> produto = service.obterPorId(id);

        if(produto.isPresent()) {
            return new ResponseEntity<>(
                mapper.map(produto.get(), ProdutoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ProdutoModeloResponse> atualizarProduto(@PathVariable String id,
        @Valid @RequestBody ProdutoModeloRequest produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.atualizarProduto(id, dto);

        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable String id) {
        service.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 


    
}
