#language: pt

Funcionalidade: Users API
  
  Cenario: Get Users
    Dado que desejo buscar os dados de Users
    Quando informo a página 2
    Então recebo uma resposta com status 200


  Esquema do Cenário: Get Users
    Dado que desejo buscar os dados de Users
    Quando informo a página <página>
    Então recebo uma resposta com status 200
    Exemplos:
      | página |
      | 1      |
      | 2      |


  Esquema do Cenário: Get Users
    Dado que desejo buscar os dados de Users
    Quando informo que desejo os dados do user de id <id>
    Então recebo uma resposta com status <status>
    Exemplos:
      | id | status |
      | 1  | 200    |
      | 2  | 200    |
      | 3  | 200    |
      | 0  | 404    |
