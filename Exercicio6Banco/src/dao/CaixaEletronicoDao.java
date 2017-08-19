package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CaixaEletronico;

public class CaixaEletronicoDao {

	private final Connection con;

	public CaixaEletronicoDao(Connection con) {
		this.con = con;
	}

	public boolean inserirCaixa(CaixaEletronico caixaEletronico) throws SQLException {
		String sql = "INSERT INTO CAIXA_ELETRONICO (CODIGO, VALOR_CAIXA) VALUES (SEQ_CAIXA.nextval, ?)";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setDouble(1, caixaEletronico.getValorCaixa());

		return statement.executeUpdate() > 0;
	}

	public List<CaixaEletronico> listarCaixas() throws SQLException {
		List<CaixaEletronico> lCaixas = new ArrayList<>();

		String sql = "SELECT * FROM CAIXA_ELETRONICO";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {

				while (rs.next()) {

					int codigo = rs.getInt("CODIGO");
					double valorCaixa = rs.getDouble("VALOR_CAIXA");

					CaixaEletronico caixaEletronico = new CaixaEletronico(codigo, valorCaixa);
					lCaixas.add(caixaEletronico);

				}

			}

			return lCaixas;
		}
	}

	public boolean sacar(CaixaEletronico caixaEletronico, double valor) throws SQLException {
		String sql = "UPDATE CAIXA_ELETRONICO SET VALOR_CAIXA = VALOR_CAIXA - ? WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setDouble(1, valor);
		statement.setInt(2, caixaEletronico.getCodigo());

		return statement.executeUpdate() > 0;

	}

	public boolean depositar(CaixaEletronico caixaEletronico, double valor) throws SQLException {
		String sql = "UPDATE CAIXA_ELETRONICO SET VALOR_CAIXA = VALOR_CAIXA + ? WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setDouble(1, valor);
		statement.setInt(2, caixaEletronico.getCodigo());

		return statement.executeUpdate() > 0;

	}

	public boolean excluirCaixa(Integer codigo) throws SQLException {
		String sql = "DELETE CAIXA_ELETRONICO WHERE CODIGO = ?";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

}
