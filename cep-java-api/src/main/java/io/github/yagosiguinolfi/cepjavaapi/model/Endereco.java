package io.github.yagosiguinolfi.cepjavaapi.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@ToString
//@Table(name = "endereco")
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private BigInteger ibge;
    private BigInteger gia;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @Value ("${new Date()}")
    private Date transactionDateTime;

}