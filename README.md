
# PÓS TECH

Tech Challenge Gerenciador de sistema de pedidos utilizando microsserviços e mensageria


## Microsserviços
Microsserviços desenvolvidos para o projeto:
* [Cliente](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/tech-client)
* [Produto](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/produto)
* [Pedido](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/tech-order)
* [Logística](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/tech-logistic)


## Tecnologias

**Spring Boot:** para a criação e estrutura dos microsserviços

**Spring Cloud Stream:** para facilitar a integração com a mensageria SQS

**Spring Batch:** para processamento em lote

**Docker:** para a criação dos containers do banco dados (PostgreSQL) e LocalStack para a utilização do SQS 

**Simple Queue Service:** Utilização para mensageria das filas


## Inicializando localmente a API

### Utilizando a API
Para fazer requisições a API é necessário o uso de algum software que tenha essa funcionalidade ( Postman, Insomnia, Apidog, ...) ou pode utilizar o terminal para rodar comandos cURL.

Caso utilize o postman, pode importar a collection que está no package .\postman

### Docker

Para inicializar a aplicação localmente é necessário o uso do Docker, caso não tenha instalado, faça
o download [aqui](https://docs.docker.com/engine/install/).

#### Docker compose

O docker compose, arquivo responsável por configurar os containers, está no package .\docker,
portanto pode rodar através da sua IDE diretamente ou pelo comando `docker-compose up` diretamente
na pasta do arquivo docker-compose.yml



## Documentação
Acesse a documentação completa do projeto:
[Documentação do projeto](https://drive.google.com/file/d/1I2tuJL-Auw-jN-d7nUMQIPXaq6roETY_/view)



## Demonstrativo
Para acessar o vídeo demonstrativo do projeto acesse
[Vídeo do projeto](https://drive.google.com/file/d/1RzdakzGO7Y4fp2VDOO82p_CkYiH4Ndti/view)
