class Loja
    def promocao_do_dia(dia)
        if dia == "quarta-feira"
            return "desconto de 10% em monitores!"
        elsif dia == "sexta-feira"
            return "desconto de 30% em artigos esportivos!"
        end
    end
end

Dado("que hoje é {string}") do |dia|
    @hoje = dia
end
  
Quando("eu pergunto qual é a promoção do dia") do
    @valor_obtido = Loja.new.promocao_do_dia(@hoje)
end
  
Então("a resposta deve ser {string}") do |promocao_esperada|
    expect(@valor_obtido).to eql promocao_esperada
end