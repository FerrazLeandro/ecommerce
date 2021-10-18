package br.com.tech4me.ecommerce.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vendas")
public class Venda {
    @Id
    private String id;
    private List<ItemVenda> itens;
    private BigDecimal totalVenda;


    public Venda(List<ItemVenda> itens, BigDecimal totalVenda) {
        this.itens = itens;
        this.totalVenda = totalVenda;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemVenda> getItens() {
        return this.itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotalVenda() {
        return this.totalVenda;
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }


    
}
