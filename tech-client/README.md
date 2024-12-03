# PÓS TECH - [Clientes]

## Features do sistema

### Cadastrar um novo cliente

Esse cadastro será efetuado pela rota POST /api/client, a documentação deste endpoint pode ser
acessada [aqui](http://localhost:8080/swagger-ui/index.html#/client-controller/createClient)

#### Atualizar um cliente

Após o cadastro, caso necessário poderemos atualizar a atualização utilizando o endpoint PUT
/api/client/{id}. A documentação deste endpoint pode ser acessada
aqui [aqui](http://localhost:8080/swagger-ui/index.html#/client-controller/updateClient)

### Buscar por um cliente

Para obter os dados de cadastro do cliente, pode-se utilizar o endpoint GET /api/client/{id}. Sua
documentação está [aqui](http://localhost:8080/swagger-ui/index.html#/client-controller/getClient)

#### Consultar todos os clientes cadastrados

Para obter uma lista com todos os clientes cadastrados, utiliza-se o endpoint GET /api/client. Cuja documentação
está [aqui](http://localhost:8080/swagger-ui/index.html#/client-controller/getClients).

## Inicializando localmente a API

### Docker

Para inicializar a aplicação localmente é necessário o uso do Docker, caso não tenha instalado, faça
o download [aqui](https://docs.docker.com/engine/install/).

#### Docker compose

O docker compose, arquivo responsável por configurar os containers, está no package .\docker,
portanto pode rodar através da sua IDE diretamente ou pelo comando `docker compose up` diretamente
na pasta do arquivo docker-compose.yml

#### Iniciando a aplicação

Utilize a IDE que melhor lhe agrade para iniciar a API

## Utilizando a API

Para fazer requisições a API é necessário o uso de algum software que tenha essa funcionalidade (
Postman, Insomnia, Apidog, ...) ou pode utilizar o terminal para rodar comandos cURL.

Caso utilize o postman, pode importar a collection que está no package .\postman