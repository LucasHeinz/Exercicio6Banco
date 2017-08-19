package model;

public class CaixaEletronico {

	private Integer codigo;
	private double valorCaixa;

	public CaixaEletronico(Integer codigo, double valorCaixa) {
		this.codigo = codigo;
		this.valorCaixa = valorCaixa;
	}

	public CaixaEletronico(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}

	@Override
	public String toString() {
		return "Caixa número: " + this.codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public double getValorCaixa() {
		return valorCaixa;
	}

	public void setValorCaixa(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}

}
