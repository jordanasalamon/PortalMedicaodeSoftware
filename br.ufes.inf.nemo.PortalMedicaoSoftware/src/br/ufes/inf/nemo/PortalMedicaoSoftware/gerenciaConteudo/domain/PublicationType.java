package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

public enum PublicationType {


	Artigo("Artigo"), 
	Tese("Tese"),
	Dissertacao("Disserta��o"),
	Monografia("Monografia"),
	Relatorio_Tecnico("Relat�rio T�cnico"),
	Livro("Livro"),
	Capitulo_Livro("Cap�tulo de Livro"),
	Padrao("Padr�o"),
	Outro("Outro");

	private String type;
	
	PublicationType(String type){
		this.type = type;
	}
	
	@Override
	public String toString(){
		return type();
	}
	
	public String type(){
		return type;
	}

}
