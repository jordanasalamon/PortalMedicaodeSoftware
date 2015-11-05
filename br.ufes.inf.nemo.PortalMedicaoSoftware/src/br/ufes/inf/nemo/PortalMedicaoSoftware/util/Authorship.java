package br.ufes.inf.nemo.PortalMedicaoSoftware.util;

public enum Authorship {

	NEMO("NEMO"), 
	Other("Other");

	private String authorship;
	
	Authorship(String authorship){
		this.authorship = authorship;
	}
	
	@Override
	public String toString(){
		return authorship();
	}
	
	public String authorship(){
		return authorship;
	}

}
