## Descrição do Projeto
Clean-Cut é uma aplicação web que permite aos usuários remover o fundo de imagens, gerenciar suas imagens e definir a privacidade das mesmas. A aplicação foi desenvolvida utilizando diversas tecnologias de front-end e back-end, com deploy na nuvem através do DigitalOcean.

## Funcionalidades do Sistema
O sistema vai permitir que o usuário possa criar uma conta, fazer login e logout, navegar pela própria galeria, pela galeria de outros usuários na página "Descobrir", postar imagens, remover o fundo de suas imagens assim como deixá-las tanto públicas quanto privadas.

## Linguagens e Frameworks Usados:
- HTML / CSS / JS - Linguagens web para desenvolvimento front-end.
- Bootstrap - Framework de estilização.
- Spring Boot - Framework back-end.
- [Rembg - Ia treinada para a remoção de backgrounds](https://github.com/danielgatis/rembg)
- Thymeleaf - Integração entre front-end e back-end.
- MySQL - Banco de dados.

## Instalação da aplicação
Clonar o repositório:
```bash
  git clone https://github.com/luizfiliperm/clean-cut.git
```
Entrar na pasta do projeto:
```bash
  cd clean-cut
```

Configurar o Banco de Dados mysql de acordo com o [application.properties](https://github.com/luizfiliperm/clean-cut/tree/main/src/main/resources)

Buildar a aplicação:
```bash
  mvn clean install
```

Executar a aplicação:
```bash
 mvn spring-boot:run
```

acessar: http://localhost:8080/

## Estrutura do Projeto
![image](https://github.com/luizfiliperm/clean-cut/assets/87551407/6ea0a377-ade7-4402-9888-ac4666b52ee2)

## Documentação
Esta aplicação foi documentada seguindo o modelo RProccess, você pode acessá-la [aqui](https://github.com/luizfiliperm/clean-cut/tree/main/doc)!
