package br.com.calcard.calsystem.util;

import java.io.File;
import java.io.FilenameFilter;

public class ListagemArquivosFilter  implements FilenameFilter {
	
	String filtro; 
	
	public String getFiltro() {
		return filtro;
	}
	
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return  name.startsWith(filtro);
	}
	
	

}
