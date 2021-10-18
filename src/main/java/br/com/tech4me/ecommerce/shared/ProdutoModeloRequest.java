package br.com.tech4me.ecommerce.shared;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ProdutoModeloRequest {
    @NotBlank(message = "Descrição do produto deve possuir caracteres não brancos")
    @NotNull(message = "Descrição do produto deve ser preenchida")
    @Size(min = 3, message= "Descrição do produto deve ter no mínimo 3 caracteres")
    private String descricao;
    @DecimalMin(value = "0.01", message= "O valor mínimo deve ser 0.01")
    private BigDecimal valorUnitario;
    @PositiveOrZero(message = "Valor em estoque não pode estar negativo")
    private Integer quantidadeEmEstoque;
    

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

}
