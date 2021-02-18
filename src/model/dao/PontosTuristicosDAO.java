package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.PontosTuristicos;

public class PontosTuristicosDAO {
	
	public void create(PontosTuristicos p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO PONTOSTUR (nome, cidade, ingresso, guia, chuva) VALUES"
							+ "(?,?,?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCidade());
			stmt.setString(3, p.getIngresso());
			stmt.setBoolean(4, p.isGuia());
			stmt.setBoolean(5, p.isChuva());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Ponto turístico salvo com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<PontosTuristicos> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<PontosTuristicos> pontosturisticos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM pontostur;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				PontosTuristicos p = new PontosTuristicos();
				p.setIdPonto(rs.getInt("idPonto"));
				p.setNome(rs.getString("nome"));
				p.setCidade(rs.getString("cidade"));
				p.setIngresso(rs.getString("ingresso"));
				p.setGuia(rs.getBoolean("guia"));
				p.setChuva(rs.getBoolean("chuva"));
				pontosturisticos.add(p);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return pontosturisticos;
	}

	public PontosTuristicos read(int idPonto) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PontosTuristicos p = new PontosTuristicos();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM pontostur WHERE idPonto=? LIMIT 1;");
			stmt.setInt(1, idPonto);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				p.setIdPonto(rs.getInt("idPonto"));
				p.setNome(rs.getString("nome"));
				p.setCidade(rs.getString("cidade"));
				p.setIngresso(rs.getString("ingresso"));
				p.setGuia(rs.getBoolean("guia"));
				p.setChuva(rs.getBoolean("chuva"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return p;
	}
	
	
	public void update(PontosTuristicos p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE pontostur SET nome=?, cidade=?, ingresso=?,"
					+ "guia=?, chuva=? WHERE idPonto=?;");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCidade());
			stmt.setString(3, p.getIngresso());
			stmt.setBoolean(4, p.isGuia());
			stmt.setBoolean(5, p.isChuva());
			stmt.setInt(6, p.getIdPonto());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Ponto turístico atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(PontosTuristicos p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM pontostur WHERE idPonto=?");
			stmt.setInt(1, p.getIdPonto());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Ponto turístico excluído com sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
}
