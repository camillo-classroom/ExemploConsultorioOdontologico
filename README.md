<h1>Exercícios - Prática de Programação OO</h1>

<h3>OBJETIVO</h3>
O objetivo destes exercícios é treinar o aluno na codificação de sistemas orientados a objetos através da construção de um sistema de exemplo.

<h3>O SISTEMA</h3>
Nesta lista de exercícios criaremos um sistema para uma clínica odontológica. Este sistema deve permitir:
Aos administradores: Cadastrar dentistas e secretários
Aos secretários: cadastrar pacientes, agendar consultas e compromissos externos
Aos dentistas: emitir receitas e atestados
Cada questão desta lista de exercícios tem o objetivo de te aproximar pouco a pouco da versão final do sistema de exemplo, ou seja, o resultado final só será conhecido ao término desta lista.

<h2>PARTE I - USUÁRIOS E CONTROLE DE ACESSO</h2>

<h3>QUESTÃO 1)</h3>
O presente sistema pode ser acessado por usuários de três tipos: dentistas, secretários e administradores. Cada usuário deve possuir um nome, um telefone, um e-mail e uma senha. Um usuário do tipo dentista deve possuir número do CRO (Conselho Regional de Odontologia). Deve ser possível ao usuário trocar a senha. Para isso, ele precisa fornecer a senha anterior, a nova senha e a confirmação da nova senha.
<br />
<strong>Questionamentos importantes:</strong>
Como representar estes três tipos de usuários? Devo utilizar para isso algum princípio da orientação a objetos?
Onde devo implementar a troca de senha?

<h3>QUESTÃO 2)</h3>
Ao executar o sistema pela primeira vez, deve existir um único usuário Admin que possui o e-mail admin@email.com, a senha @dmin123 e é do tipo Administrador. O sistema deve possibilitar o login e o logout de usuários. Se nenhum usuário estiver logado, a tela de login deve ser apresentada. Se existir usuário logado, apresente uma tela de boas vindas para este usuário e apresente um menu contendo as opções de logout e sair. No primeiro login, o usuário deve ser obrigado a trocar a senha do usuário.
<br />
<strong>Questionamento importante:</strong>
Como criar o usuário Admin na primeira execução do sistema?

<h3>QUESTÃO 3)</h3>
Além de poder realizar todas as tarefas realizadas por secretários, os usuários administradores são os únicos que podem cadastrar novos usuários. Caso o usuário logado seja um administrador, apresente uma opção a mais no menu: Cadastrar Usuário. No cadastro de usuários, deve ser solicitado o tipo do usuário (dentista, secretário ou administrador) e, em acordo com o tipo do usuário, deve ser solicitado o preenchimento de todos os atributos do objeto em questão. Todo novo usuário cadastrado deve possuir a senha usu@rio123 e, no primeiro login, o sistema deve solicitar a troca desta senha. 
<br />
<strong>Quetionamento importante:</strong>
Como diferenciar qual usuário está logado? Lembre-se que apenas administradores podem cadastrar novos usuários.

<h3>QUESTÃO 4)</h3>
Na alteração de um usuário, o usuário administrador não pode digitar uma nova senha para esse usuário. O melhor é apresentar uma opção no menu de usuários que permita resetar a senha de um usuário, de forma que a mesma seja trocada para usu@rio123 e exija troca de senha no próximo login do usuário que teve a sua senha resetada.
 
<h3>QUESTÃO 5)</h3>
<strong>a)</strong> Qual a forma correta de se armazenar senhas de usuários?
Qual o risco do vazamento dos dados de nossos usuários se guardarmos as senhas dos mesmos?

<strong>b)</strong> O problema do polimorfismo - dando o primeiro passo em direção à solução deste problema
O controle do tipo do usuário no sistema, dependendo da forma que você efetuou, pode ter exigido uma série de comandos condicionais (IF’s). Você consegue pensar em alguma forma de criar o menu específico para cada usuário sem a necessidade de verificar o tipo do usuário que está logado com comandos condicionais?

<h3>QUESTÃO 6)</h3>
Faça o CRUD (Create Read Update Delete) de pacientes. Um paciente possui nome, e-mail e telefone. Apenas usuários do tipo 'Secretario' e 'Administrador' podem cadastrar pacientes.

<h3>QUESTÃO 7)</h3>
Crie as agendas para cada dentista. Um usuário do tipo 'Dentista' deve conseguir acessar somente a própria agenda. Um usuário do tipo 'Secretario' pode acessar a agenda de qualquer dentista. A agenda deve permitir agendar consultas e compromissos externos. Consultas devem estar associadas a um determinado paciente.




