
# bibliotecaunisul

O sistema possui uma tela inicial onde se pode navegar entre os Menus do Professor, Aluno, Livro e Exemplar. Clicando no botão escolhido,
abrirá uma nova tela feita em SWING com o respectivo menu escolhido. Nessa nova janela, será possível realizar as operações que são atribuidas
ao tipo escolhido.

No "Menu do Professor" possuem três campos: Nome, Matricula e Cursos que, quando preenchidos corretamente, é possível realizar todas as operações.
A consulta no banco de dados é feita pela matrícula. Se a matrícula for "inválida", abre uma janela avisando que o professor não existe, caso
for uma matrícula "válida", os campos Nome e Cursos são preenchidos conforme os dados no banco de dados.

O "Menu do Aluno" também possui três campos com nomes parecidos com o do "Menu do Professor", só que ao invés de possuir uma lista de cursos
possui somente um único curso. É possível realizar todas as operações e a pesquisa de aluno no banco de dados é feita pela matrícula, também abrindo
uma nova janela avisando que o aluno não existe caso a matrícula não exista. Se exister a matrícula, os campos Nome e Curso são preenchidos.

"Menu Livro" possui os campos: Título, ID e Autor e é possível Deletar um livro, adicionar um livro e pesquisar um livro pelo seu título.
Mesmo fornecendo o ID, no banco de dados ele fica dando increment desde o meu primeiro teste... Confesso que não consegui arrumar.

Dentro do "Menu Exemplar" é possível ver todos os livros cadastrados no banco de dados e escolher entre eles para cadastrar um exemplar daquele livro,
informando a sua localização e edição.
