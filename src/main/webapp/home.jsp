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
            <p class="text">O iFood est� mudando a forma com qual eles recebem (incluem) e atualizam os restaurantes parceiros na plataforma.</p>

            <p class="text highlighted">Desafio</p>

            <p class="text">Definir quais dados s�o relevantes para o restaurante parceiro fornecer para a plataforma do iFood e depois disso, como podemos extrair tr�s insights desses dados</p>
        </div>

        <div class="section insight pt-2">
            <div class="infos">
                <p class="text">Sabrina est� amando turistar por S�o Paulo. Depois de passar a manh� inteira passendo pelo bairro ${enderecoTipo}, est� com dificuldade para escolher qual ser� o seu almo�o. Gra�as ao iFood, ela consegue descobrir que ${tipoRestaurante} � o
                    ponto forte daquela regi�o!
                </p>
                <p class="text query">O bairro ${enderecoTipo} possui ${restaurantesTipo} restaurantes com foco em ${tipoRestaurante}</p>
            </div>

            <div class="people"></div>
        </div>


        <div class="section insight pt-3">

            <div class="infos">
                <p class="text">Rodrigo n�o teve uma boa experi�ncia em um outro app de delivery, pois al�m do prato escolhido ser caro, a comida estava fria e sem tempero. Decidiu ent�o conhecer o iFood, j� que ele prioriza os restaurantes que possuem uma boa rela��o
                    entre Avalia��o e Faixa de Pre�o.</p>

                <p class="text query">Existem ${restaurantesAvaliacao} restaurantes com pratos de pre�o m�dio pr�ximo a R$ ${precoAvaliacao} e que possuem avalia��o superior a ${avaliacao} estrelas</p>
            </div>

            <div class="people"></div>
        </div>

        <div class="section insight pt-4">

            <div class="infos">
                <p class="text">Carla est� planejando uma viagem e n�o poderia deixar de pensar na sua alimenta��o durante as suas f�rias. Para facilitar, est� pesquisando os restaurantes pr�ximos aos hot�is que ela se hospedar� e dividindo pela faixa de pre�o. Assim,
                    ela consegue equilibrar entre os dias de economizar e experimentar os polos gastron�micos da cidade. </p>

                <p class="text query">Em ${enderecoHoteis}, existem ${restaurantesHoteis} restaurantes com o pre�o m�dio de R$ ${precoHoteis} por prato e 27 restaurantes com o pre�o m�dio de R$80,00 por prato</p>
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