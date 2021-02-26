package br.com.mouawad.estudos.spring.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"PEssoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int n,String s) {
		this.cod = n;
		this.descricao = s;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Codigo nao existe: " + cod);
		
	}
}
