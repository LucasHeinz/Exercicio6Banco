package teste;

import java.sql.SQLException;
import java.util.List;

import model.*;
import service.*;

public class CaixaEletronicoTeste {

	public static void main(String[] args) throws SQLException {
		
		CaixaEletronicoService caixaEletronicoService = new CaixaEletronicoService();
		CaixaEletronico caixaEletronico = new CaixaEletronico(1000000);
		
		caixaEletronicoService.inserirCaixa(caixaEletronico);
		
		caixaEletronicoService.depositar(caixaEletronico, 100);
		caixaEletronicoService.sacar(caixaEletronico, 500);
		
		List<CaixaEletronico> lCaixa = caixaEletronicoService.listarCaixas();
		for (CaixaEletronico caixa : lCaixa) {
			System.out.println(caixa.toString() + caixa.getValorCaixa());
		}
		
	}
}
