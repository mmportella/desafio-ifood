package br.com.fiap.ifood.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ifood.model.Pedido;

public class PedidoDAO {

	/**
	 * Método para recuperar todos os pedidos de um restaurante.
	 * @return Uma lista de todos os registros de pedidos.
	 */
	public List<Pedido> getAll(int cdRestaurante) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Pedido> listaPedidos = null;
		try {
			listaPedidos = new ArrayList<Pedido>();
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_IFD_PEDIDO WHERE RESTAURANTE_CD_RESTAURANTE = ?");
			stmt.setInt(1, cdRestaurante);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Pedido p = new Pedido();
				p.setCdPedido(rs.getLong("CD_PEDIDO"));
				p.setEnderecoEntrega(rs.getString("ENDERECO"));
				p.setValorPedido(rs.getFloat("VL_PEDIDO"));
				p.setValorTaxa(rs.getFloat("VL_TAXA"));
				listaPedidos.add(p);
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
		return listaPedidos;
	}
	
	
	/**
	 * Método para retornar um pedido de um restaurante pelo código.
	 */
	public Pedido getByCd(int cdPedido) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_IFD_PEDIDO WHERE CD_PEDIDO = ?");
			stmt.setInt(1, cdPedido);
			ResultSet rs = stmt.executeQuery();
			Pedido p = new Pedido();
			if (rs.next()) {
				p.setCdPedido(rs.getLong("CD_PEDIDO"));
				p.setEnderecoEntrega(rs.getString("ENDERECO"));
				p.setValorPedido(rs.getFloat("VL_PEDIDO"));
				p.setValorTaxa(rs.getFloat("VL_TAXA"));
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
	 * Método para inserir um registro de pedido.
	 */
	public int add(Pedido pedido, int cdRestaurante) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_IFD_PEDIDO (CD_PEDIDO, ENDERECO, VL_PEDIDO, VL_TAXA, RESTAURANTE_CD_RESTAURANTE) VALUES "
					+ "(SEQ_PRODUTO.nextval, ?, ?, ?, ?)");
			stmt.setString(1, pedido.getEnderecoEntrega());
			stmt.setFloat(2, pedido.getValorPedido());
			stmt.setFloat(3, pedido.getValorTaxa());
			stmt.setInt(4, cdRestaurante);
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
	 * Método para modificar um registro de pedido.
	 */
	public int update(Pedido p) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("UPDATE T_IFD_PEDIDO SET ENDERECO = ?, VL_PEDIDO = ?, VL_TAXA = ? WHERE CD_PEDIDO = ?");
			stmt.setString(1, p.getEnderecoEntrega());
			stmt.setFloat(2, p.getValorPedido());
			stmt.setFloat(3, p.getValorTaxa());
			stmt.setLong(4, p.getCdPedido());
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
	 * Método para excluir um registro de pedido.
	 */
	public int delete(int cdPedido) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_IFD_PEDIDO WHERE CD_PEDIDO = ?");
			stmt.setInt(1, cdPedido);
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
