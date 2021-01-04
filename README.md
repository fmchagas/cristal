# Clistal
Fintech Cristal é uma API com endpoint cadastro de cliente desenvolvida para suporte ao artigo de desafio

## Começando
Para executar o projeto, será necessário instalar os seguintes programas:
* Java 11


## Observação
* Projeto usa ecossistema Spring
* H2 como banco de dados em arquivo

## Desenvolvimento

* Para iniciar o desenvolvimento Tenha uma IDE(eclipse com STS) e clone o projeto do GitHub num diretório:

```shell
cd "<seu diretório>"
git clone https://github.com/fmchagas/cristal.git
```

* Rode a aplicação
```shell
cd "<diretório raiz da aplicação>"
./mvnw spring-boot:run
```
## Documentação
Abra o navegador e digite:
```shell
http://localhost:8080/swagger-ui.html
```

##Cadastre um cliente
POST http://localhost:8080/cristal/v1/clientes : cria um cliente
Corpo da Solicitação:
{
    "nome":"Fernando",
    "email":"fernando@gmail.com",
    "cpf":"06874315064",
    "dataDeNascimento":"1987-11-14"
}

Retornar os seguintes códigos:
201: se criado com sucesso e no payload(corpo da resposta) retorna as informações do cliente criado
400: se a solicitação falhou na validação, informar no payload quais campos não estão validos