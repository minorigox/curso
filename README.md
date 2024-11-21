DESAFIO ACADEMIA SAP COMMERCE
Plataforma de cursos online Accenture Academy.

Tecnologias:
- Spring Boot;
- Spring MVC;
- Spring Data JPA;
- Banco de dados H2.

Práticas Adotadas:
- API REST
- Consultas com Spring Data JPA
- Injeção de dependências

Como executar:
- Clonar repositório git;
- Construir e subir o projeto;
- As APIs poderão ser acessadas pelo endereço: http://localhost:8080;

API Endpoints:

Cadastrar um aluno:
[POST] localhost:8080/alunos
{
  "nome": "{nome_do_aluno}",
  "email": "{email_do_aluno}"
}

Detalhar um aluno:
[GET] localhost:8080/alunos/{id_do_aluno}

Listar alunos:
[GET] localhost:8080/alunos

Cadastrar um curso:
[POST] localhost:8080/cursos
{
  "nome": "{nome do curso}",
  "descricao": "{descrição do curso}"
}

Detalhar um curso:
[GET] localhost:8080/cursos/{id_do_curso}

Listar cursos:
[GET] localhost:8080/cursos

Inscrever um aluno em um curso:
[POST] localhost:8080/inscricao
{
  "aluno_id": "{id_do_aluno}",
  "curso_id": "{id_do_curso}"
}

Listar cursos de um aluno:
[GET] localhost:8080/inscricao/aluno/{id_do_aluno}

Listar alunos de um curso:
[GET] localhost:8080/inscricao/curso/{id_do_curso}
