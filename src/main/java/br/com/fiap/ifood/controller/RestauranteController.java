package br.com.fiap.ifood.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.fiap.ifood.model.Restaurante;
import br.com.fiap.ifood.model.dao.RestauranteDAO;
//import br.com.fiap.ifood.model.insight.*;

@WebServlet("/home")
public class RestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RestauranteController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bairro = "Liberdade";
		// PrimeiroInsight primeiro = new PrimeiroInsight(bairro);
		// int restaurantesTipo = primeiro.getRestaurantesTipo();
		// String tipoRestaurante = primeiro.getTipoRestaurante();
		int restaurantesTipo = 25;
		String tipoRestaurante = "comida japonesa";
		request.setAttribute("restaurantesTipo", restaurantesTipo);
		request.setAttribute("enderecoTipo", bairro);
		request.setAttribute("tipoRestaurante", tipoRestaurante);

		float precoAvaliacao = 40.0f;
		int avaliacao = 4;
		// SegundoInsight segundo = new SegundoInsight(precoAvaliacao, avaliacao);
		// int restaurantesAvaliacao = segundo.getRestaurantesAvaliacao();
		int restaurantesAvaliacao = 15;
		request.setAttribute("restaurantesAvaliacao", restaurantesAvaliacao);
		request.setAttribute("precoAvaliacao", precoAvaliacao);
		request.setAttribute("avaliacao", avaliacao);

		String enderecoHoteis = "Ipanema";
		float precoHoteis = 30.0f;
		// TerceiroInsight terceiro = new TerceiroInsight(enderecoHoteis, precoHoteis);
		// int restaurantesHoteis = terceiro.getRestaurantesHoteis();
		int restaurantesHoteis = 35;
		request.setAttribute("enderecoHoteis", enderecoHoteis);
		request.setAttribute("restaurantesHoteis", restaurantesHoteis);
		request.setAttribute("precoHoteis", precoHoteis);

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


			Restaurante restaurante = new Restaurante(); int controle = 0;

		 try {
		 
		 restaurante.setCnpj(Integer.parseInt(request.getParameter("cnpj")));
		 restaurante.setNomeRestaurante(request.getParameter("nomeRestaurante"));
		 restaurante.setEndereco(request.getParameter("endereco"));
		 restaurante.setTelefone(Integer.parseInt(request.getParameter("telefone")));
		 restaurante.setTipoRestaurante(request.getParameter("tipoRestaurante"));
		 restaurante.setHorarioFuncionamento(request.getParameter("horarioFuncionamento"));
		 restaurante.setPedidoMinimo(Float.parseFloat(request.getParameter("pedidoMinimo")));

		 RestauranteDAO rdao = new RestauranteDAO(); controle = rdao.add(restaurante);
		 
		 request.setAttribute("restaurante", restaurante);
		 
		 if (controle == 1) {
		 request.getRequestDispatcher("sucesso.jsp").forward(request, response); }
		 else { 
			 response.sendRedirect(response.encodeRedirectURL("falha.jsp")); 
		 }
		 } catch (Exception e) { 
			 e.printStackTrace(); 
		 	}
		 

	}

}
