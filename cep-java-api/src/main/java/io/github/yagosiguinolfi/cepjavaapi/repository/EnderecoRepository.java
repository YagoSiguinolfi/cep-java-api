package io.github.yagosiguinolfi.cepjavaapi.repository;

import io.github.yagosiguinolfi.cepjavaapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

    @PersistenceContext
    EntityManager entityManager = null;

    @Query(value = "select e.cep from Endereco e "
            + "where e.cep = :cep ")
    Optional<Endereco> verifyDuplicate(@Param("cep") String cep);

    @Query(value = "select e.uf from Endereco e group by e.uf")
    List<String> findAllUf();

    @Query(value = "select e.localidade from Endereco e " +
            "where e.uf = :uf group by e.localidade")
    List<String> findAllLocalidade(String uf);

    List<Endereco> findByLocalidade(String localidade);

    List<Endereco> findByUf(String uf);
/*
    @Query(value = "select e.cep, e.logradouro, e.complemento, e.bairro," +
            " e.localidade, e.uf, e.unidade, e.ibge, e.gia, e.transactionDateTime from Endereco e "
            + "where e.cep = :cep")
    Endereco findAndVerifyByCep(String cep);
*/
    @Transactional
    default Endereco insert(Endereco endereco) {
        this.entityManager.persist(endereco);
        return endereco;
    }
}
