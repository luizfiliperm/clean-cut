## Descrição do Projeto
Clean-Cut é uma aplicação web que permite aos usuários remover o fundo de imagens, gerenciar suas imagens e definir a privacidade das mesmas. A aplicação foi desenvolvida utilizando diversas tecnologias de front-end e back-end, com deploy na nuvem através do DigitalOcean.

## Funcionalidades do Sistema
O sistema vai permitir que o usuário possa criar uma conta, fazer login e logout, navegar pela própria galeria, pela galeria de outros usuários na página "Descobrir", postar imagens, remover o fundo de suas imagens assim como deixá-las tanto públicas quanto privadas.

## Linguagens e Frameworks Usados:
- HTML / CSS / JS - Linguagens web para desenvolvimento front-end.
- Bootstrap - Framework de estilização.
- Spring Boot - Framework back-end.
- Open cv - biblioteca de processamento de imagens
- Thymeleaf - Integração entre front-end e back-end.
- MySQL - Banco de dados.

## Instalação da aplicação
Clonar o repositório: git clone https://github.com/luizfiliperm/clean-cut.git
Executar repositório: cd clean-cut

Configurar o Banco de Dados mysql de acordo com o application.properties aqui:
https://github.com/luizfiliperm/clean-cut/tree/main/src/main/resources

Construir e Executar a aplicação:
mvn clean install
mvn spring-boot:run

acessar: http://localhost:8080/

## Estrutura do Projeto
![image](https://github.com/luizfiliperm/clean-cut/assets/87551407/6ea0a377-ade7-4402-9888-ac4666b52ee2)
