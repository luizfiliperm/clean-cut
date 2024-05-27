# Clean-cut

|       **Integrantes**        |
|:----------------------------:|
|       João Pedro Soares      |
|       Luiz Filipe Matos      |
| Maria Vitória Berto de Souza |
|    Rafael Benitez Andrade    |

## Requisitos funcionais e não funcionais

|          **Requisitos Funcionais**          |    **Requisitos não Funcionais**   |
|:-------------------------------------------:|:----------------------------------:|
|              1. Registrar conta             | 1. Criptografar a senha do usuário |
|           2. Fazer login na conta           |         2. Site responsivo         |
|          3. Remover fundo da imagem         |       3. Interface Intuitiva       |
|       4. Definir privacidade da imagem      |                                    |
|         5. Visualizar minhas imagens        |                                    |
| 6. Vizualizar imagens públicas em descobrir |                                    |
|               7. Fazer Logout               |                                    |
|         8. Fazer download da imagem         |                                    |

## Diagrama de Classes

![diagrama de classes do projeto](https://github.com/luizfiliperm/clean-cut/blob/documentacao/doc/class-diagram.png)

## Linguagens e Frameworks usados:

1. HTML / CSS / JS - linguagens web / front end
2. Bootstrap - framework de estilização
3. Springboot - framework backend
4. Open cv - biblioteca de processamento de imagens
5. Thymeleaf - integração front end e back end
6. MySQL - banco de dados

## Ambiente de Deploy
A ainda definir

## Metodologia RProcess
## 1 - Registrar Usuário
### História de Usuário
- Como um novo usuário
- Quero registrar uma conta
- Para acessar e usar as funcionalidades do site.

### Critérios de Aceite
1. O sistema deve permitir ao usuário inserir um nome de usuário, email e senha. 
2. O sistema deve verificar se essa conta já existe. 
3. A senha deve ser inserida duas vezes para confirmar. 

### Cenário de Execução
- Dado que estou na página de login
- Quando eu preencho os campos de nome de usuário, email e senha e clico no botão "Registrar"
- Então tenho minha conta imediatamente registrada no site.

## 2 - Fazer Login na conta
### História de Usuário
- Como um usuário registrado
- Quero fazer login na minha conta
- Para acessar minhas imagens e outras funcionalidades.

### Critérios de Aceite
1. O sistema deve permitir ao usuário inserir seu email e senha.
2. O login deve ser bem-sucedido apenas se as credenciais forem válidas.
3. A conta a ser acessada deve ser uma conta já existente.

### Cenários de Execução
- Dado que estou na página de login
- Quando eu insiro meu email e senha incorretos e clico no botão "Login"
- Então eu recebo uma mensagem de erro informando que as credenciais estão incorretas.
<br>

- Dado que estou na página de login
- Quando eu insiro meu email e senha corretamente e clico no botão "Login"
- Então eu posso acessar o site livremente.

## 3 - Remover fundo da imagem
### História de Usuário
- Como um usuário
- Quero remover o fundo de uma imagem
- Para usar a imagem sem o fundo original.

### Critérios de Aceite
1. O sistema deve permitir ao usuário fazer upload de uma imagem.
2. O sistema deve remover o fundo da imagem.

### Cenários de Execução
- Dado que estou na página de edição de imagens
- Quando eu faço upload de uma imagem e clico no botão "Remover Fundo"
- Então vejo a imagem com o fundo removido.
<br>

- Dado que estou na página de edição de imagens
- Quando eu faço upload de uma imagem em um formato não suportado e clico no botão "Remover Fundo"
- Então eu recebo uma mensagem de erro informando que o formato da imagem não é suportado.

## 4 - Definir Privacidade da Imagem
### História de Usuário
- Como um usuário
- Quero definir a privacidade da minha imagem
- Para controlar quem pode ver minhas imagens.

### Critérios de Aceite
1. O sistema deve permitir ao usuário escolher entre as opções de privacidade (privado, público).
2. A opção deve ser aplicável para todas as imagens individualmente.

### Cenários de Execução
- Dado que estou na página de visualização das minhas imagens
- Quando eu seleciono uma imagem e escolho a opção "Privada"
- Então a imagem é marcada como privada e só eu posso vê-la.
<br>

- Dado que estou na página de visualização das minhas imagens
- Quando eu seleciono uma imagem e escolho a opção "Pública"
- Então a imagem é marcada como pública e todos na plataforma podem vê-la.

## 5 - Visualizar Minhas Imagens
### História de Usuário
- Como um usuário
- Quero visualizar minhas imagens
- Para gerenciar e editar as imagens que carreguei.

### Critérios de Aceite
1. O sistema deve listar todas as imagens carregadas pelo usuário.
2. O usuário deve poder ver detalhes e opções de edição para cada imagem.

### Cenários de Execução
- Dado que estou na página principal da minha conta
- Quando eu navego para a secão "Minhas Imagens"
- Então eu vejo uma lista de todas as minhas imagens carregadas.
<br>

- Dado que estou na seção "Minhas Imagens"
- Quando eu clico em uma imagem
- Então vejo detalhes de edição para essa imagem.

## 6 - Vizualizar Imagens Públicas em Descobrir
### História de Usuário
- Como um usuário
- Quero visualizar imagens de outros usuários
- Para descobrir novas imagens.

### Critérios de Aceite
1. O sistema deve permitir ao usuário navegar por imagens públicas de outros usuários.
2. O usuário deve poder ver detalhes das imagens compartilhadas publicamente.

### Cenários de Execução
- Dado que estou na página principal da minha conta
- Quando eu navego para a seção "Descobrir"
- Então eu vejo uma galeria de imagens públicas de outros usuários.

## 7 - Fazer Logout
### Histórias de Usuário
- Como um usuário
- Quero fazer logout da minha conta
- Para fazer login em uma outra conta.

### Critérios de Aceite
1. O sistema deve fornecer uma opção clara de logout.
2. O logout deve encerrar a sessão do usuário e redirecioná-lo para a página de login.

### Cenários de Execução
- Dado que estou logado na minha conta
- Quando eu clico no botão "Logout"
- Então minha sessão é encerrada e sou redirecionado para a página de login.
<br>

- Dado que estou logado na minha conta
- Quando eu tento acessar uma página que requer login
- Então sou redirecionado para a página de login.

## 8 - Fazer download da Imagem
### Históra de Usuário
- Como um usuário
- Quero fazer um download da imagem já editada
- Para tê-la salva em minha máquina pessoal.

### Critérios de Aceite
1. O sistema deve fornecer um botão com uma opção para fazer o download da imagem.
2. O sistema deve fazer um download da imagem em .jpg na máquina do usuário.

### Cenários de Execução
- Dado que estou na página de "remover o fundo da imagem"
- Quando eu clico no botão "Fazer download"
- Então o sistema baixa a imagem já editada na minha máquina.

## Protótipo e Regras de Negócio

### Tela inicial do site:
![image](https://github.com/luizfiliperm/clean-cut/assets/87551407/8fab7f1d-a4f0-4d18-aad9-9fc10af16b0d)

