package br.com.fiap.ifood.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.fiap.ifood.model.Restaurante;
import br.com.fiap.ifood.model.dao.RestauranteDAO;

@WebServlet("/home")
public class RestauranteNovoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RestauranteNovoController() {
        super();
    }
	
	
	// Método para chamar a página JSP
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");  
		rd.forward(request, response);
	}
	
	// Método que o formulário da home.jsp usa para cadastrar o restaurante.
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		Restaurante restaurante = new Restaurante();
		int controle = 0;
		
		try {
			
			restaurante.setCnpj(Integer.parseInt(request.getParameter("cnpj")));
			restaurante.setNomeRestaurante(request.getParameter("nomeRestaurante"));
			restaurante.setEndereco(request.getParameter("endereco"));
			restaurante.setTelefone(Integer.parseInt(request.getParameter("telefone")));
			restaurante.setTipoRestaurante(request.getParameter("tipoRestaurante"));
			restaurante.setHorarioFuncionamento(request.getParameter("horarioFuncionamento"));
			restaurante.setAvaliacao(Integer.parseInt(request.getParameter("avaliacao")));
			restaurante.setPedidoMinimo(Float.parseFloat(request.getParameter("pedidoMinimo")));
			restaurante.setRetirada(Boolean.parseBoolean(request.getParameter("retirada")));
			
			RestauranteDAO rdao = new RestauranteDAO();
			controle = rdao.add(restaurante);
			
			request.setAttribute("restaurante", restaurante);
			
			if (controle == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("restaurante-novo-sucesso.jsp");  
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("restaurante-novo-falha.jsp");  
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
