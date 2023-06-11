
# rhp-app-banckend
- API rodando no link http://localhost:8080/reuniao/cadastrar   ou http://localhost:8080/funcionario
- /funcionário (endpoint) {get,post,update,delete}
- /reuniao (endpoint)    {cadastrar,atualizar,}

- Utilize uma ferramenta para testar a API com os metodos POST,PUT,DELETE E GET

## Exemplo de requisição POST

```bash
 {
      "idFuncionario": 1,
      "nome": "Yuri",
      "email": "yuri@example.com",
      "senha": "123456"
    }
```

```bash

{
  "moment":"22/05/2020",
  "nomereuniao": "Reuniao",
  "inicio_reuniao": "11h",
	 "q_Pessoas":"3",
  "termino_reuniao": "12h",
  "convidados": [
    {
      "idFuncionario": 1,
      "nome": "Yuri",
      "email": "yuri@example.com",
      "senha": "123456"
    },
    {
      "idFuncionario": 2,
      "nome": "Ana",
      "email": "Ana@example.com",
      "senha": "12345"
    }
  ]
}


