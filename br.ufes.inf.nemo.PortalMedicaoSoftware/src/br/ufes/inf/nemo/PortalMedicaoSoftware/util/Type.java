package br.ufes.inf.nemo.PortalMedicaoSoftware.util;

public enum Type {


	Artigo("Artigo"), 
	Tese_de_Doutorado("Tese de Doutorado"),
	Dissertacao_de_Mestrado("Dissertação de Mestrado"),
	Monografia("Monografia"),
	Relatorio_Tecnico("Relatório Técnico"),
	Livro("Livro"),
	Outro("Outro");

	private String type;
	
	Type(String type){
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
