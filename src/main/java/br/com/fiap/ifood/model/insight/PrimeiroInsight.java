package br.com.fiap.ifood.model.insight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.fiap.ifood.model.dao.ConnectionManager;

public class PrimeiroInsight {
	
	private int restaurantesTipo;
	private String enderecoTipo;
	private String tipoRestaurante;
	
	
	
	public PrimeiroInsight(String enderecoTipo) {
		this.enderecoTipo = enderecoTipo;
		Query();
	}
	
	
	
	private void Query() {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT COUNT(TP_RESTAURANTE), TP_RESTAURANTE FROM T_IFD_RESTAURANTE WHERE ENDERECO = ? "
					+ "GROUP BY TP_RESTAURANTE HAVING COUNT(TP_RESTAURANTE) > 1 ORDER BY count(TP_RESTAURANTE) DESC;");
			stmt.setString(1, this.enderecoTipo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			this.restaurantesTipo = rs.getInt("COUNT(TP_RESTAURANTE)");
			this.tipoRestaurante = rs.getString("TP_RESTAURANTE");
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int getRestaurantesTipo() {
		return this.restaurantesTipo;
	}
	
	
	
	public String getTipoRestaurante() {
		return this.tipoRestaurante;
	}
	
}
