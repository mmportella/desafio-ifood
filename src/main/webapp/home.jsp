<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/estilo.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Ifood</title>
</head>

<body>

    <header class="header">

        <div class="title">

            <h1>Challenge</h1>
            <div class="logo"></div>
        </div>

        <div class="icons">

            <div class="img entregadores"></div>
            <div class="img restaurantes"></div>
            <div class="img clientes"></div>

        </div>

    </header>

    <main>

        <div class="section pt-1">
            <p class="text">O iFood está mudando a forma com qual eles recebem (incluem) e atualizam os restaurantes parceiros na plataforma.</p>

            <p class="text highlighted">Desafio</p>

            <p class="text">Definir quais dados são relevantes para o restaurante parceiro fornecer para a plataforma do iFood e depois disso, como podemos extrair três insights desses dados</p>
        </div>

        <div class="section insight pt-2">
            <div class="infos">
                <p class="text">Sabrina está amando turistar por São Paulo. Depois de passar a manhã inteira passendo pelo bairro ${enderecoTipo}, está com dificuldade para escolher qual será o seu almoço. Graças ao iFood, ela consegue descobrir que ${tipoRestaurante} é o
                    ponto forte daquela região!
                </p>
                <p class="text query">O bairro ${enderecoTipo} possui ${restaurantesTipo} restaurantes com foco em ${tipoRestaurante}</p>
            </div>

            <div class="people"></div>
        </div>


        <div class="section insight pt-3">

            <div class="infos">
                <p class="text">Rodrigo não teve uma boa experiência em um outro app de delivery, pois além do prato escolhido ser caro, a comida estava fria e sem tempero. Decidiu então conhecer o iFood, já que ele prioriza os restaurantes que possuem uma boa relação
                    entre Avaliação e Faixa de Preço.</p>

                <p class="text query">Existem ${restaurantesAvaliacao} restaurantes com pratos de preço médio próximo a R$ ${precoAvaliacao} e que possuem avaliação superior a ${avaliacao} estrelas</p>
            </div>

            <div class="people"></div>
        </div>

        <div class="section insight pt-4">

            <div class="infos">
                <p class="text">Carla está planejando uma viagem e não poderia deixar de pensar na sua alimentação durante as suas férias. Para facilitar, está pesquisando os restaurantes próximos aos hotéis que ela se hospedará e dividindo pela faixa de preço. Assim,
                    ela consegue equilibrar entre os dias de economizar e experimentar os polos gastronômicos da cidade. </p>

                <p class="text query">Em ${enderecoHoteis}, existem ${restaurantesHoteis} restaurantes com o preço médio de R$ ${precoHoteis} por prato e 27 restaurantes com o preço médio de R$80,00 por prato</p>
            </div>

            <div class="people"></div>
        </div>

        <div class="section new">

            <p class="text highlighted">Novo restaurante</p>

            <form>
                <div class="form-group">
                    <label>Nome do restaurante</label>
                    <input class="form-control" type="text" required>
                </div>
                <div class="form-group">
                    <label>CNPJ</label>
                    <input class="form-control" type="text" required>
                </div>
                <div class="form-group">
                    <label>Bairro</label>
                    <input class="form-control" type="text" required>
                </div>
                <div class="form-group">
                    <label for="type">Categoria</label>
                    <select class="form-control" id="type" required>
                      <option selected disabled>Selecione</option>
                      <option>Japonesa</option>
                      <option>Pizzaria</option>
                      <option>Italiana</option>
                      <option>Hamburgueria</option>
                      <option>Chinesa</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Telefone</label>
                    <input class="form-control" type="text" required>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </div>
    </main>


</body>

</html>