package io.github.yagosiguinolfi.cepjavaapi.controller;

import io.github.yagosiguinolfi.cepjavaapi.model.Endereco;
import io.github.yagosiguinolfi.cepjavaapi.repository.EnderecoRepository;
import io.github.yagosiguinolfi.cepjavaapi.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoController {

    private EnderecoRepository repository;
    private EnderecoService service;

    EnderecoController(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/uf"})
    public List findAllGroupByUf(){
        List<String> ufList = repository.findAllUf();
        List endList = new ArrayList();
        for(String uf: ufList){
            List<Endereco> enderList = repository.findByUf(uf);
            endList.add(enderList);
        }
        return endList;
    }

    @GetMapping(path = {"/{cep}"})
    public ResponseEntity findById(@PathVariable String cep){
        return repository.findById(cep)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
/*
    @GetMapping(path = {"/verify/{cep}"})
    public ResponseEntity findByCep(@PathVariable String cep){
        return repository.findAndVerifyByCep(cep)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
*/
    @GetMapping(path = {"/uf/{uf}"})
    public List findByUfGroupByLocalidade(@PathVariable String uf){
        List<String> localList = repository.findAllLocalidade(uf);
        List endList = new ArrayList();
        for(String localidade: localList){
            List<Endereco> enderList = repository.findByLocalidade(localidade);
            endList.add(enderList);
        }
        return endList;
    }

    @GetMapping(path = {"/localidade/{localidade}"})
    public List findByLocalidade(@PathVariable String localidade){
        return repository.findByLocalidade(localidade);
    }

    @PostMapping
    public Endereco create(@RequestBody Endereco endereco){
        return repository.save(endereco);
    }

    @PutMapping(value="/{cep}")
    public ResponseEntity update(@PathVariable String cep,
                                 @RequestBody Endereco endereco) {
        return repository.findById(cep)
                .map(record -> {
                    record.setCep(endereco.getCep());
                    record.setLogradouro(endereco.getLogradouro());
                    record.setComplemento(endereco.getComplemento());
                    record.setBairro(endereco.getBairro());
                    record.setLocalidade(endereco.getLocalidade());
                    record.setUf(endereco.getUf());
                    record.setUnidade(endereco.getUnidade());
                    record.setIbge(endereco.getIbge());
                    record.setGia(endereco.getGia());
                    Endereco updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{cep}"})
    public ResponseEntity <?> delete(@PathVariable String cep) {
        return repository.findById(cep)
                .map(record -> {
                    repository.deleteById(cep);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
