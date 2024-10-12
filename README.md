# Av2BackEnd

Trabalho BACKEND - André Luiz Oenning
Tema:Quiz


O Projeto utiliza um arquivo JSON para armazenar as informações localmente e rete-las

ENDPOINTS DA API:

1 - Listar Perguntas

Com o método GET e utilizando o mapeamento ("/quiz"), o código retorna uma lista de todas as perguntas cadastradas, neste formato:[
  {
    "id": 1,
    "texto": "Qual foi o primeiro presidente dos Estados Unidos?",
    "alternativaA": "George Washington",
    "alternativaB": "Abraham Lincoln",
    "alternativaC": "Thomas Jefferson",
    "alternativaD": "John Adams",
    "respostaCorreta": "A"
  },
  {
    "id": 2,
    "texto": "Qual é o maior planeta do sistema solar?",
    "alternativaA": "Terra",
    "alternativaB": "Júpiter",
    "alternativaC": "Marte",
    "alternativaD": "Vênus",
    "respostaCorreta": "B"
  }
]

2 - Buscar perguntas por ID 

Novamente com o método GET, podemos obter uma pergunta especifica por seu id a partir do mapeamento ("/quiz/{id da pergunta aqui}"), ex:("/quiz/1"), deve retornar neste formato JSON:
{
  "id": 1,
  "texto": "Qual foi o primeiro presidente dos Estados Unidos?",
  "alternativaA": "George Washington",
  "alternativaB": "Abraham Lincoln",
  "alternativaC": "Thomas Jefferson",
  "alternativaD": "John Adams",
  "respostaCorreta": "A"
}

3 - Buscar pergunta aleatória

Com o GET novamente, podemos obter uma pergunta randomica da base de dados a partir do mapeamento ("/quiz/aleatorio"), no mesmo formato JSON do ENDPOINT anterior

4 - Adicionar nova pergunta

Com o método Post, podemos adicionar uma pergunta (que será armazenada em arquivo JSON local, assim como as preexistentes) ao quiz, com o mapeamento("/quiz/salvar") com o corpo tendo esta estrutura:
{
  "texto": "Qual é a capital da França?",
  "alternativaA": "Paris",
  "alternativaB": "Londres",
  "alternativaC": "Berlim",
  "alternativaD": "Madri",
  "respostaCorreta": "A"
}

e com esse retorno:

{
  "id": 3,
  "texto": "Qual é a capital da França?",
  "alternativaA": "Paris",
  "alternativaB": "Londres",
  "alternativaC": "Berlim",
  "alternativaD": "Madri",
  "respostaCorreta": "A"
}

5- Deletar pergunta 

Usando o metodo Delete, no mapeamento("/quiz/{id da pergunta}") remove uma pergunta do JSON armazenado localmente, recebendo resposta um JSON com esta estrutura:
{
  "mensagem": "Apagado"
  "correta": True 
}

6- Responder a pergunta

Usando o metodo post, no mapeamento("/quiz/responder"), a requisição verifica se a resposta fornecida de uma questão está correta, devendo ter o seguinte formato:

{
  "perguntaId": 1,
  "resposta": "A"
}

e retorna:
{
  "mensagem": "Resposta Correta"
  "correta": True 
}

ou 
{
  "mensagem": "Resposta Errada"
  "correta": False
}

