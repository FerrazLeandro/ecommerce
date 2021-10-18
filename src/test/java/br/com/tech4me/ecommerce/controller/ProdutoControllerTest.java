package br.com.tech4me.ecommerce.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import br.com.tech4me.ecommerce.shared.ProdutoModeloRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ProdutoControllerTest {
    @Autowired
    private MockMvc mock;
    
    @Test
    public void deve_retornar_406_com_json_incompleto() throws Exception{
        String json = "{}";

        mock.perform(post("/api/produtos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isNotAcceptable());

    }

    @Test
    public void deve_retornar_201_com_json_completo() throws Exception{
        ProdutoModeloRequest prod = new ProdutoModeloRequest();
        prod.setDescricao("Água");
        prod.setValorUnitario(new BigDecimal("1.99"));
        prod.setQuantidadeEmEstoque(10);

        ObjectMapper map = new ObjectMapper();
        String json = map.writeValueAsString(prod);

        mock.perform(post("/api/produtos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.descricao").value("Água"))
        .andExpect(jsonPath("$.valorUnitario").value("1.99"));

    }

    @Test
    public void deve_retornar_200_com_json_completo() throws Exception{ 
        mock.perform(get("/api/produtos")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    }
}
