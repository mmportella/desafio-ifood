package br.com.fiap.ifood.model.dao;

import br.com.fiap.ifood.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	
	/**
	 * Método para recuperar todos os produtos de um restaurante.
	 * @return Uma lista de todos os registros de produtos.
	 */
	public List<Produto> getAll(int cdRestaurante) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> listaProdutos = null;
		try {
			listaProdutos = new ArrayList<Produto>();
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_IFD_PRODUTO WHERE RESTAURANTE_CD_RESTAURANTE = ?");
			stmt.setInt(1, cdRestaurante);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setCdProduto(rs.getInt("CD_PRODUTO"));
				p.setNomeProduto(rs.getString("NM_PRODUTO"));
				p.setPreco(rs.getFloat("PRECO"));
				listaProdutos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaProdutos;
	}
	
	
	/**
	 * Método para retornar um produto de um restaurante por código do produto.
	 */
	public Produto getByCd(int cdRestaurante, int cdProduto) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_IFD_PRODUTO WHERE CD_PRODUTO = ? AND RESTAURANTE_CD_RESTAURANTE = ?");
			stmt.setInt(1, cdProduto);
			stmt.setInt(2, cdRestaurante);
			ResultSet rs = stmt.executeQuery();
			Produto p = new Produto();
			if (rs.next()) {
				p.setCdProduto(rs.getInt("CD_PRODUTO"));
				p.setNomeProduto(rs.getString("NM_PRODUTO"));
				p.setPreco(rs.getFloat("PRECO"));
			}
			rs.close();
			stmt.close();
			conexao.close();
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Método para inserir um registro de produto de um restaurante.
	 */
	public int add(Produto produto, int cdRestaurante) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_IFD_PRODUTO (CD_PRODUTO, NM_PRODUTO, PRECO, RESTAURANTE_CD_RESTAURANTE) VALUES "
					+ "(SEQ_PRODUTO.nextval, ?, ?, ?)");
			stmt.setString(1, produto.getNomeProduto());
			stmt.setFloat(2, produto.getPreco());
			stmt.setInt(3, cdRestaurante);
			stmt.executeUpdate();
			conexao.commit();
			stmt.close();
			conexao.close();
			return 1;
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	/**
	 * Método para modificar um registro de produto.
	 */
	public int update(Produto p, int cdRestaurante) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("UPDATE T_IFD_PRODUTO SET CD_PRODUTO = ?, NM_PRODUTO = ?, PRECO = ? WHERE RESTAURANTE_CD_RESTAURANTE = ?");
			stmt.setInt(1, p.getCdProduto());
			stmt.setString(2, p.getNomeProduto());
			stmt.setFloat(3, p.getPreco());
			stmt.setInt(4, cdRestaurante);
			stmt.executeUpdate();
			conexao.commit();
			stmt.close();
			conexao.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * Método para excluir um registro de produto.
	 */
	public int delete(int cdProduto) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_IFD_PRODUTO WHERE CD_PRODUTO = ?");
			stmt.setInt(1, cdProduto);
			stmt.executeUpdate();
			conexao.commit();
			stmt.close();
			conexao.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}