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
|   6. Visualizar imagens de outros usuário   |                                    |
|        7. Substituir fundo da imagem        |                                    |
| 8. Vizualizar imagens públicas em descobrir |                                    |
|               9. Fazer Logout               |                                    |

## Diagrama de Classes

![diagrama de classes do projeto](https://github.com/luizfiliperm/clean-cut/blob/documentacao/doc/class-diagram.png)

## Linguagens e Frameworks usados:

1. HTML / CSS / JS - linguagens web / front end
2. Bootstrap - framework de estilização
3. Springboot - framework backend
4. Thymeleaf - integração front end e back end
5. MySQL - banco de dados

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
2. O sistema deve verificar de essa conta já existe. 
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
