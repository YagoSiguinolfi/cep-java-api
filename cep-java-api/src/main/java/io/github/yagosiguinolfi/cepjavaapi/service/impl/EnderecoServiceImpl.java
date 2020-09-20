package io.github.yagosiguinolfi.cepjavaapi.service.impl;

import io.github.yagosiguinolfi.cepjavaapi.exception.DuplicateEnderecoException;
import io.github.yagosiguinolfi.cepjavaapi.model.Endereco;
import io.github.yagosiguinolfi.cepjavaapi.repository.EnderecoRepository;
import io.github.yagosiguinolfi.cepjavaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco insert(Endereco endereco) {
        return enderecoRepository.insert(endereco);
    }


    @Override
    public Endereco findAll(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco verifyDuplicate(String cep) throws DuplicateEnderecoException {
        return enderecoRepository.verifyDuplicate(cep).orElseThrow(() ->
                new DuplicateEnderecoException("Já existe um registro com o mesmo CEP"));
    }

    @Override
    public List<Endereco> findByLocalidade(String localidade){
        List<Endereco> enderecoList = enderecoRepository.findByLocalidade(localidade);
        return enderecoList;
    }

    @Override
    public List<String> findAllLocalidade(String uf){
        List<String> localList = enderecoRepository.findAllLocalidade(uf);
        return localList;
    }

    @Override
    public List<Endereco> findByUf(String uf){
        List<Endereco> enderecoList = enderecoRepository.findByUf(uf);
        return enderecoList;
    }

    @Override
    public List<String> findAllUf(){
        List<String> ufList = enderecoRepository.findAllUf();
        return ufList;
    }

    @Override
    public Endereco verificaInsert(String cep){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", Endereco.class);
    }

    @Override
    public ResponseEntity insere(String cep){
        Endereco endereco = this.verificaInsert(cep);
        endereco = enderecoRepository.save(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cep}").buildAndExpand(endereco.getCep()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
