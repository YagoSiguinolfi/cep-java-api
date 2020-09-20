package io.github.yagosiguinolfi.cepjavaapi.repository;

import io.github.yagosiguinolfi.cepjavaapi.model.Endereco;
import io.github.yagosiguinolfi.cepjavaapi.service.EnderecoService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.ThrowableTypeAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(EnderecoRepository.class)
public class EnderecoRepositoryTest {
/*
    public static final long DELAY = (1000 * 12);
    public static final long PERIOD = (1000 * 48);
    private static int count = 0;

    private static final String CEP = "14403166";
    private static final String LOGRADOURO = "";
    private static final String COMPLEMENTO = "";
    private static final String BAIRRO = "";
    private static final String LOCALIDADE = "";
    private static final String UF = "";
    private static final String UNIDADE = "";
    private static final BigInteger IBGE = BigInteger.valueOf(6545584);
    private static final BigInteger GIA = BigInteger.valueOf(316641);
    private static final LocalDateTime TRANSACTIONDATE = null;
//    private static final Endereco ENDERECO = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, BAIRRO,
//            LOCALIDADE, UF, UNIDADE, IBGE, GIA, TRANSACTIONDATE);

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void givenEnderecoEntity_whenInsertWithEntityManager_thenEnderecoIsPersisted(Endereco endereco) {
        insertEnderecoWithEntityManager(ENDERECO);
        assertEnderecoPersisted(ENDERECO);
    }

    @Test
    public void givenEnderecoEntity_whenInsertedTwiceWithEntityManager_thenEntityExistsExceptionIsThrown(Endereco endereco) {
        assertThatExceptionOfType(EntityExistsException.class).isThrownBy(() -> {
            insertEnderecoWithEntityManager(ENDERECO);
            insertEnderecoWithEntityManager(ENDERECO);
        });
    }

    private void buscaCeps(){

        RestTemplate restTemplate = new RestTemplate();

        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                public void run() {
                    do {
                        long l = (long) (Math.random() * 99999999);
                        String n = String.format("%08d", l);
                        System.out.println(n);
                        try {
                            Endereco end = restTemplate.getForObject("https://viacep.com.br/ws/" + n + "/json/", Endereco.class);

                            if(end.getCep() != null){
                                System.out.println(end);
                                insertEnderecoWithEntityManager(end);
                                count++;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (count < 5);
                }
            };
            timer.scheduleAtFixedRate(tarefa, DELAY, PERIOD);
        }
    }

    private void insertEnderecoWithEntityManager(Endereco endereco) {
        enderecoRepository.insertWithEntityManager(ENDERECO);
    }

    private void assertEnderecoPersisted(Endereco end) {
        Endereco endereco = entityManager.find(Endereco.class, ENDERECO.getCep());

        assertThat(endereco).isNotNull();
        assertThat(endereco.getCep()).isEqualTo(ENDERECO.getCep());
        assertThat(endereco.getLogradouro()).isEqualTo(ENDERECO.getLogradouro());
        assertThat(endereco.getComplemento()).isEqualTo(ENDERECO.getComplemento());
        assertThat(endereco.getBairro()).isEqualTo(ENDERECO.getBairro());
        assertThat(endereco.getLocalidade()).isEqualTo(ENDERECO.getLocalidade());
        assertThat(endereco.getUf()).isEqualTo(ENDERECO.getUf());
        assertThat(endereco.getUnidade()).isEqualTo(ENDERECO.getUnidade());
        assertThat(endereco.getIbge()).isEqualTo(ENDERECO.getIbge());
        assertThat(endereco.getGia()).isEqualTo(ENDERECO.getGia());
        assertThat(endereco.getTransactionDate()).isEqualTo(ENDERECO.getTransactionDate());
    }
*/
}
