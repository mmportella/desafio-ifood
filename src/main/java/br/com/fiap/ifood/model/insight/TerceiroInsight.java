package br.com.fiap.ifood.model.insight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.ifood.model.dao.ConnectionManager;

public class TerceiroInsight {

	private String enderecoHoteis;
	private int restaurantesHoteis;
	private float precoHoteis;
	
	
	
	public TerceiroInsight(String enderecoHoteis, float precoHoteis) {
		this.enderecoHoteis = enderecoHoteis;
		this.precoHoteis = precoHoteis;
		this.restaurantesHoteis = Query();
	}


	
	private int Query() {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT COUNT(NM_RESTAURANTE) FROM T_IFD_RESTAURANTE WHERE "
					+ "ENDERECO = ? AND PRECO_MEDIO BETWEEN ?*0.95 AND ?*1.05;");
			stmt.setString(1, this.enderecoHoteis);
			stmt.setFloat(2, this.precoHoteis);
			stmt.setFloat(3, this.precoHoteis);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int controle = rs.getInt("COUNT(NM_RESTAURANTE)");
			rs.close();
			stmt.close();
			conexao.close();
			return controle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	public int getRestaurantesHoteis() {
		return restaurantesHoteis;
	}

}
