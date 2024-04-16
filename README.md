# Sistema de Gerenciamento de Eventos

Este projeto implementa um sistema de gerenciamento de eventos usando um frontend em React + TypeScript e um backend em Java com Quarkus. O sistema permite aos usuários gerenciar instituições e eventos com recursos robustos como operações CRUD, tarefas agendadas para gestão de dados e validação abrangente de dados.

## Frontend (React + TypeScript)

### Estrutura do Projeto

- **Inicialização**: Use `create-react-app` com TypeScript para configurar o projeto.
- **Estrutura de Pastas**: Organize o projeto em pastas para componentes, serviços e testes unitários.

### Componentes Principais

- **Cabeçalho**: Exibe o título "Cadastro de Eventos" alinhado à esquerda.
- **Menu Lateral**: Inclui links para "Instituições" e "Eventos".
- **Tela de Instituições**: Mostra uma lista de instituições com opções para adicionar e editar.
- **Tela de Eventos**: Mostra uma lista de eventos com filtros e opções para adicionar e editar.
- **Rodapé**: Contém o aviso de direitos autorais "Copyright 20224 by Rafael Freitas".

### Validações de Formulário

- **Campos de Data**: Garanta que a data de início não seja posterior à data final.
- **Campos Obrigatórios**: Exija que todos os campos especificados sejam preenchidos.

### Testes Unitários

- **Framework**: Implemente testes unitários para cada componente usando Jest e Testing Library.

## Backend (Java 22 + Quarkus 3.9.3)

### Estrutura do Projeto

- **Arquitetura**: Implemente uma Arquitetura Hexagonal para isolar o domínio da aplicação das tecnologias externas.
- **Domínios**: "Instituição" e "Evento" são modelados como entidades centrais.

### Endpoints REST

- **Operações CRUD**: Crie endpoints para gerenciar instituições e eventos.
- **Validação de Dados**: Assegure que as validações de data sejam cumpridas de acordo com as regras de negócio.
- **Tratamento de Erros**: Implemente o manejo de erros conforme as melhores práticas.

### Microserviço de Ativação de Eventos

- **Agendador**: Utilize o Quarkus Scheduler para executar uma tarefa diária às 00:01 que verifica e atualiza o status dos eventos com base em suas datas programadas.

### Persistência

- **Banco de Dados**: Utilize o PostgreSQL como o sistema de gerenciamento de banco de dados.
- **Relacionamentos de Entidade**: Configure entidades e relacionamentos apropriados, incluindo chaves estrangeiras.

## Instruções de Configuração

### Configuração do Ambiente

1. **Clone o Repositório**: 
2. **Instale as Dependências** (Frontend):
cd frontend
npm install
3. **Instale as Dependências** (Backend):
cd backend
mvn install

### Executando a Aplicação

1. **Inicie o Servidor Backend**:
cd backend
./mvnw quarkus:dev

2. **Inicie a Aplicação Frontend**:
cd frontend
npm start

3. **Acesse a Aplicação**:
- Abra `http://localhost:3000` no seu navegador para ver o frontend.
- A API do backend estará disponível em `http://localhost:8080`.

### Configuração Adicional

- **Conexão com o Banco de Dados**: Configure as strings de conexão do PostgreSQL no arquivo de propriedades da aplicação localizado no diretório `src/main/resources` do backend.

## Contribuindo

Contribuições para este projeto são bem-vindas. Por favor, leia as diretrizes de contribuição antes de enviar pull requests.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE.md).

