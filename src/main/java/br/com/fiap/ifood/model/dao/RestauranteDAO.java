package br.com.fiap.ifood.model.dao;

import br.com.fiap.ifood.model.Restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {
	
	/**
	 * Método para recuperar todos os restaurantes.
	 * @return Uma lista de todos os registros de restaurantes.
	 */
	@SuppressWarnings("finally")
	public List<Restaurante> getAll() {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Restaurante> listaRestaurante = null;
		try {
			listaRestaurante = new ArrayList<Restaurante>();
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_IFD_RESTAURANTE");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Restaurante r = new Restaurante();
				r.setCdRestaurante(rs.getInt("CD_RESTAURANTE"));
				r.setCnpj(rs.getInt("CNPJ"));
				r.setNomeRestaurante(rs.getString("NM_RESTAURANTE"));
				r.setEndereco(rs.getString("ENDERECO"));
				r.setTelefone(rs.getInt("TELEFONE"));
				r.setTipoRestaurante(rs.getString("TP_RESTAURANTE"));
				r.setHorarioFuncionamento(rs.getString("HR_FUNCIONAMENTO"));
				r.setAvaliacao(rs.getInt("AVALIACAO"));
				r.setPedidoMinimo(rs.getFloat("PEDIDO_MINIMO"));
				r.setRetirada(rs.getBoolean("RETIRADA"));
				listaRestaurante.add(r);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listaRestaurante;
		}
	}
	
	
	/**
	 * Método para recuperar um restaurante pelo cdRestaurante.
	 * @param cdRestaurante Código do restaurante a ser pesquisado.
	 */
	public Restaurante getByCd(int cdRestaurante) {
		Restaurante r = new Restaurante();
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_IFD_RESTAURANTE WHERE CD_RESTAURANTE = ?");
			stmt.setInt(1, cdRestaurante);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				r.setCdRestaurante(rs.getInt("CD_RESTAURANTE"));
				r.setCnpj(rs.getInt("CNPJ"));
				r.setNomeRestaurante(rs.getString("NM_RESTAURANTE"));
				r.setEndereco(rs.getString("ENDERECO"));
				r.setTelefone(rs.getInt("TELEFONE"));
				r.setTipoRestaurante(rs.getString("TP_RESTAURANTE"));
				r.setHorarioFuncionamento(rs.getString("HR_FUNCIONAMENTO"));
				r.setAvaliacao(rs.getInt("AVALIACAO"));
				r.setPedidoMinimo(rs.getFloat("PEDIDO_MINIMO"));
				r.setRetirada(rs.getBoolean("RETIRADA"));
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	
	/**
	 * Método para adicionar um novo registro de restaurante.
	 * @param r Objeto a ser adicionado.
	 */
	public int add(Restaurante r) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_IFD_RESTAURANTE (CD_RESTAURANTE, CNPJ, NM_RESTAURANTE, "
					+ "ENDERECO, TELEFONE, TP_RESTAURANTE, HR_FUNCIONAMENTO, AVALIACAO, PEDIDO_MINIMO, RETIRADA) VALUES (SEQ_RESTAURANTE.nextval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, r.getCnpj());
			stmt.setString(2, r.getNomeRestaurante());
			stmt.setString(3, r.getEndereco());
			stmt.setInt(4, r.getTelefone());
			stmt.setString(5, r.getTipoRestaurante());
			stmt.setString(6, r.getHorarioFuncionamento());
			stmt.setInt(7, r.getAvaliacao());
			stmt.setFloat(8, r.getPedidoMinimo());
			stmt.setBoolean(9, r.isRetirada());
			stmt.execute();
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
	 * Método para atualizar um registro de restaurante.
	 */
	public int update(Restaurante r) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("UPDATE T_IFD_RESTAURANTE SET CNPJ = ?, NM_RESTAURANTE = ?, ENDERECO = ?, TELEFONE = ?, "
					+ "TP_RESTAURANTE = ?, HR_FUNCIONAMENTO = ?, AVALIACAO = ?, PEDIDO_MINIMO = ?, RETIRADA = ? WHERE CD_RESTAURANTE = ?");
			stmt.setInt(1, r.getCnpj());
			stmt.setString(2, r.getNomeRestaurante());
			stmt.setString(3, r.getEndereco());
			stmt.setInt(4, r.getTelefone());
			stmt.setString(5, r.getTipoRestaurante());
			stmt.setString(6, r.getHorarioFuncionamento());
			stmt.setInt(7, r.getAvaliacao());
			stmt.setFloat(8, r.getPedidoMinimo());
			stmt.setBoolean(9, r.isRetirada());
			stmt.setInt(10, r.getCdRestaurante());
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
	 * Método para excluir registro de restaurante
	 */
	public int delete(int cdRestaurante) {
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_IFD_RESTAURANTE WHERE CD_RESTAURANTE = ?");
			stmt.setInt(1, cdRestaurante);
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