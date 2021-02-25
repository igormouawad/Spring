package br.com.mouawad.estudos.spring01.domain;


import java.util.Date;

import javax.persistence.Entity;

import br.com.mouawad.estudos.spring01.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date DataPAgamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,Date dataVencimento,Date DataPAgamento ) {
		super(id, estadoPagamento, pedido);
		this.DataPAgamento = DataPAgamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPAgamento() {
		return DataPAgamento;
	}

	public void setDataPAgamento(Date dataPAgamento) {
		DataPAgamento = dataPAgamento;
	}
	
	
}
