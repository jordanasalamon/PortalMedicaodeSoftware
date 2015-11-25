package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

public enum PublicationType {


	Artigo("Artigo"), 
	Tese("Tese"),
	Dissertacao("Dissertação"),
	Monografia("Monografia"),
	Relatorio_Tecnico("Relatório Técnico"),
	Livro("Livro"),
	Capitulo_Livro("Capítulo de Livro"),
	Padrao("Padrão"),
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
