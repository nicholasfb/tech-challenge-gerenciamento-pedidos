
# PÓS TECH

Tech Challenge Gerenciador de sistema de pedidos utilizando microserviços e mensageria


## Microserviços
Microserviços desenvolvidos para o projeto:
* [Cliente](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/tech-client)
* [Produto](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/produto)
* [Pedido](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/tech-order)
* [Logística](https://github.com/nicholasfb/tech-challenge-gerenciamento-pedidos/tree/master/tech-logistic)


## Tech Stack

**Spring Boot:** para a criação e estrutura dos microserviços

**Spring Cloud Stream:** para facilitar a integração com a mensageria SQS

**Spring Batch:** para processamento em lote

**Docker:** para a criação dos containers do banco dados (PostgreSQL) e 
LocalStack para a utilização do SQS


## Inicializando localmente a API

### Docker

Para inicializar a aplicação localmente é necessário o uso do Docker, caso não tenha instalado, faça
o download [aqui](https://docs.docker.com/engine/install/).

#### Docker compose

O docker compose, arquivo responsável por configurar os containers, está no package .\docker,
portanto pode rodar através da sua IDE diretamente ou pelo comando `docker-compose up` diretamente
na pasta do arquivo docker-compose.yml



## Documentação
Acesse a documentação completa do projeto:
[Documentação do projeto](https://drive.google.com/file/d/1gA8kQYpnAkf1ooQS1cdGT4ysTPxhULWF/view?usp=drive_link)
