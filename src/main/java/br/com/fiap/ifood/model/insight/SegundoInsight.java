package br.com.fiap.ifood.model.insight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.ifood.model.dao.ConnectionManager;

public class SegundoInsight {

	private float precoAvaliacao;
	private int restaurantesAvaliacao;
	private int avaliacao;
	
	
	
	public SegundoInsight(float precoAvaliacao, int avaliacao) {
		this.precoAvaliacao = precoAvaliacao;
		this.avaliacao = avaliacao;
		this.restaurantesAvaliacao = Query();
	}
	
	
	
	private int Query() {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT COUNT(CD_RESTAURANTE) FROM T_IFD_RESTAURANTE WHERE PRECO_MEDIO BETWEEN ?*0.95 AND ?*1.05 AND AVALIACAO > ?;");
			stmt.setFloat(1, this.precoAvaliacao);
			stmt.setFloat(2, this.precoAvaliacao);
			stmt.setInt(3, this.avaliacao);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int controle = rs.getInt("COUNT(CD_RESTAURANTE)");
			rs.close();
			stmt.close();
			conexao.close();
			return controle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	public int getRestaurantesAvaliacao() {
		return restaurantesAvaliacao;
	}
	
}
