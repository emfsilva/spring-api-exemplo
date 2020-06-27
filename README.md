### SPRING API EXEMPLO

API com simples funcionalidades de adcionar um nome e um email, e integrar com front end feito em angular.

Deploy no Heroku com banco de dados postgress para "**prod**", para testes em "**dev**" foi usado banco postgress local, com instância em docker,  e para testes em memoria usado o h2 "**test**", alteração do ambiente é feita via flag no **properties** do projeto.

###### Documentação swagger
https://springboot-user.herokuapp.com/swagger-ui.html#/user-controller

######  API no HEROKU
https://springboot-user.herokuapp.com/users

A aplicação front-end em angular ainda não foi feito o deploy, mas testes podem ser feitos utilizando o **SWAGGER**, **POSTMAN** ou qual quer outro clint que faz requisições.

