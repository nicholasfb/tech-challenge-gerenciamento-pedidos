package br.com.postech.tech_gerenciamento_pedido.controller;

import br.com.postech.tech_gerenciamento_pedido.repository.jpa.ClientJpaRepository;
import br.com.postech.tech_gerenciamento_pedido.repository.model.ClientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @BeforeEach
    void setUp() {
        clientJpaRepository.deleteAll();
    }

    @Test
    void createClient_retorna201Created() throws Exception {
        String clienteJson
                = "{\"name\":\"Cliente Teste\", \"document\":\"12345678900\", \"email\":\"teste@teste.com\", \"phone\":\"12345678\"}";

        mockMvc.perform(post("/api/client")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(clienteJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getClients_retorna200Ok() throws Exception {
        ClientEntity cliente = new ClientEntity();
        cliente.setName("Cliente Teste");
        cliente.setDocument("12345678900");
        cliente.setEmail("teste@teste.com");
        cliente.setPhone("12345678");
        clientJpaRepository.save(cliente);

        mockMvc.perform(get("/api/client")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getClient_retorna200Ok() throws Exception {
        ClientEntity cliente = new ClientEntity();
        cliente.setName("Cliente Teste");
        cliente.setDocument("12345678900");
        cliente.setEmail("teste@teste.com");
        cliente.setPhone("12345678");
        cliente = clientJpaRepository.save(cliente);

        mockMvc.perform(get("/api/client/" + cliente.getId())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cliente.getId()))
                .andExpect(jsonPath("$.name").value(cliente.getName()))
                .andExpect(jsonPath("$.document").value(cliente.getDocument()))
                .andExpect(jsonPath("$.email").value(cliente.getEmail()))
                .andExpect(jsonPath("$.phone").value(cliente.getPhone()));
    }

    @Test
    void getClient_retorna204NoContent() throws Exception {
        mockMvc.perform(get("/api/client/999")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void updateClient_retorna202Accepted() throws Exception {
        ClientEntity cliente = new ClientEntity();
        cliente.setName("Cliente Antigo");
        cliente.setDocument("12345678900");
        cliente.setEmail("antigo@teste.com");
        cliente.setPhone("12345678");
        cliente = clientJpaRepository.save(cliente);

        String clienteAtualizadoJson
                = "{\"name\":\"Cliente Atualizado\", \"document\":\"12345678900\", \"email\":\"atualizado@teste.com\", \"phone\":\"87654321\"}";

        mockMvc.perform(put("/api/client/" + cliente.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(clienteAtualizadoJson))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.name").value("Cliente Atualizado"))
                .andExpect(jsonPath("$.email").value("atualizado@teste.com"))
                .andExpect(jsonPath("$.phone").value("87654321"));
    }

    @Test
    void updateClient_retorna422UnprocessableEntity() throws Exception {
        String clienteJson
                = "{\"name\":\"Cliente Atualizado\", \"document\":\"12345678900\", \"email\":\"atualizado@teste.com\", \"phone\":\"87654321\"}";

        mockMvc.perform(put("/api/client/999")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(clienteJson))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void deleteClient_retorna200Ok() throws Exception {
        ClientEntity cliente = new ClientEntity();
        cliente.setName("Cliente Para Deletar");
        cliente.setDocument("12345678900");
        cliente.setEmail("deletar@teste.com");
        cliente.setPhone("12345678");
        cliente = clientJpaRepository.save(cliente);

        mockMvc.perform(delete("/api/client/" + cliente.getId())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteClient_retorna204NoContent() throws Exception {
        mockMvc.perform(delete("/api/client/999")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}

