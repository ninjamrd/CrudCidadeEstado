# CrudCidadeEstado

Um CRUD simples para duas tabelas: **Estado** e **Cidade**, com as funcionalidades básicas de:

- Listar registros
- Salvar novos dados
- Atualizar registros existentes
- Excluir registros

## Tecnologias utilizadas

- **H2 Database** – Sistema de gerenciamento de banco de dados (SGBD) leve e em memória
- **Flyway** – Controle de versionamento e migrações do banco de dados
- **Hibernate** – ORM para facilitar a conexão e manipulação dos dados no banco
- **Swing** – Biblioteca gráfica utilizada para criar a interface do sistema
- **Maven** – Gerenciador de dependências e estruturação do projeto

## Como executar o projeto

1. Clone o repositório ou baixe o projeto
2. Abra o projeto no **NetBeans**
3. Execute a classe `CrudCidadeEstado.java`, localizada em:
./CrudCidadeEstado/src/main/java/com/mycompany/crudcidadeestado


## Guia de Uso

### Adicionar uma nova cidade

1. Preencha o campo **Nome** com o nome da cidade.
2. Selecione um **Estado** no combo box ao lado.
3. Clique no botão **Salvar**.
4. A nova cidade será adicionada à tabela abaixo.

### Editar uma cidade existente

1. Selecione a cidade desejada na tabela clicando sobre ela.
2. Preencha os campos de **Nome** e **Estado** com os novos valores desejados.
3. Clique no botão **Editar**.
4. A tabela será atualizada com as novas informações.

### Excluir uma cidade

1. Selecione a cidade na tabela.
2. Clique no botão **Excluir**.
3. A cidade será removida da lista.

o uso é o mesmo para as funcionabilidades de estado
