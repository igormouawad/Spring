package br.com.mouawad.estudos.spring.domain;


import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.mouawad.estudos.spring.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,Date dataVencimento,Date DataPAgamento ) {
		super(id, estadoPagamento, pedido);
		this.dataPagamento = DataPAgamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPAgamento() {
		return dataPagamento;
	}

	public void setDataPAgamento(Date dataPAgamento) {
		dataPagamento = dataPAgamento;
	}
	
	
}
