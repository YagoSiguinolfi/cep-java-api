package io.github.yagosiguinolfi.cepjavaapi.service;

import io.github.yagosiguinolfi.cepjavaapi.exception.DuplicateEnderecoException;
import io.github.yagosiguinolfi.cepjavaapi.model.Endereco;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnderecoService {

    Endereco save(Endereco endereco);

    Endereco insert(Endereco endereco);

    Endereco findAll(Endereco endereco);

    Endereco verifyDuplicate(String cep) throws DuplicateEnderecoException;

//    List<Endereco> findByUfOrderByLocalidade(String uf);

    List<String> findAllUf();

    List<String> findAllLocalidade(String uf);

    List<Endereco> findByUf(String uf);

    List<Endereco> findByLocalidade(String localidade);

    Endereco verificaInsert(String cep);

    ResponseEntity insere(String cep);
}
