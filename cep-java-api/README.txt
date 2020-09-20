API Rest Spring

Utilizando JDK 11 e Bando Oracle XE;

Configuração do arquivo para conexão do banco:
- acesse o arquivo cep-java-api/src/main/resources/application.properties;
- altere os parâmetros circundados com ""(aspas duplas), com a SID do banco, o NOME do usuário e a SENHA do mesmo, removendo as aspas;

se necessário, alterar o dialeto do banco no parâmetro: spring.jpa.database-platform.

Rodando a APi:
- Ao executar a API, o banco precisará ser populado pois não foi possível consumir a API ViaCep.


Endpoint para busca de:
- todos os cep's = localhost:8080/enderecos

- um cep = localhost:8080/enderecos/{cep}

- todos os cep's agrupados por estado = localhost:8080/enderecos/uf

- todos os cep's de um determinado estado agrupado por cidade = localhost:8080/enderecos/uf/{uf}

- todos os cep's de uma determinada cidade = localhost:8080/enderecos/localidade/{localidade}


Para inserir dados:
- Utilizar localhost:8080/enderecos 
- Inserindo {"cep", logradouro, complemento, bairro, localidade, uf, ibge, gia, transactionDateTime}