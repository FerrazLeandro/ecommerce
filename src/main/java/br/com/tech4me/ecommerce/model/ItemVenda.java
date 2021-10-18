package br.com.tech4me.ecommerce.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("itens")
public class ItemVenda {
    @Id
    private String id;
    private Produto produto;
    private Integer quantidadeVendida;
    private BigDecimal valorTotalItem;

    public ItemVenda(Produto produto, Integer quantidadeVendida, BigDecimal valorTotalItem) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotalItem = valorTotalItem;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    public BigDecimal getValorTotalItem() {
        return valorTotalItem;
    }
    public void setValorTotalItem(BigDecimal valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    
    
}
