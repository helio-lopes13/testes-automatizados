#language:pt

Funcionalidade: Promoção do dia!
    Queremos saber qual é a promoção do dia na loja XYZ

Cenário: Hoje é dia de descontos em eletrônicos
    Dado que hoje é "quarta-feira"
    Quando eu pergunto qual é a promoção do dia
    Então a resposta deve ser "desconto de 10% em monitores!"

Cenário: Hoje é dia de descontos em artigos esportivos
    Dado que hoje é "sexta-feira"
    Quando eu pergunto qual é a promoção do dia
    Então a resposta deve ser "desconto de 30% em artigos esportivos!"