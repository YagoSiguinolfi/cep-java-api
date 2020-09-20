package io.github.yagosiguinolfi.cepjavaapi;

import io.github.yagosiguinolfi.cepjavaapi.controller.EnderecoController;
import io.github.yagosiguinolfi.cepjavaapi.model.Endereco;
import io.github.yagosiguinolfi.cepjavaapi.repository.EnderecoRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@EnableScheduling - comentado pois a execução repetida de executaBase faz com que o site ViaCep bloqueie seu ip
public class BuscadorDeCeps {

    private final long PERIOD = (1000 * 60);
    private int count = 0;
    EnderecoRepository repository;

    @Scheduled(fixedDelay = PERIOD)
    public void executaBusca(){
        do {
            long l = (long) (Math.random() * 99999999);
            String n = String.format("%08d", l);
            System.out.println(n);
            try {
                RestTemplate restTemplate = new RestTemplate();
                Endereco end = restTemplate.getForObject("https://viacep.com.br/ws/" + n + "/json/", Endereco.class);
                if(end.getCep() != null){
                    System.out.println(end);
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (count < 5);

    }
}
