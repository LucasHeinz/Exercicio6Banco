package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CaixaEletronicoDao;
import jdbc.ConnectionPoolOracle;
import model.CaixaEletronico;

public class CaixaEletronicoService {

	public void inserirCaixa(CaixaEletronico caixaEletronico) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CaixaEletronicoDao(con).inserirCaixa(caixaEletronico);
		}
	}

	public void sacar(CaixaEletronico caixaEletronico, double valorSaque) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			if (valorSaque > caixaEletronico.getValorCaixa()) {
				throw new IllegalArgumentException("Esta saque não pode ser efetuado.");
			} else {
				new CaixaEletronicoDao(con).sacar(caixaEletronico, valorSaque);
			}
		}
	}

	public void depositar(CaixaEletronico caixaEletronico, double valorDeposito) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CaixaEletronicoDao(con).depositar(caixaEletronico, valorDeposito);
		}
	}

	public void excluirCaixa(Integer codigo) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CaixaEletronicoDao(con).excluirCaixa(codigo);
		}
	}

	public List<CaixaEletronico> listarCaixas() throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			return new CaixaEletronicoDao(con).listarCaixas();
		}

	}
}
