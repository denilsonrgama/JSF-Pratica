package br.com.fiapon.imoveis.service;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import com.google.gson.Gson;
import br.com.fiapon.imoveis.entity.Theme;

@Model //Compomente - possui uma saida de negocio, um serviço, os dados da aplicação
public class ThemePreferenceService implements Serializable{

	private static final long serialVersionUID = 1L;
	private String theme; 
	private List<Theme> themes;
	

	public ThemePreferenceService() {

		try {
			//Busca o path real do deploy no servidor
			String path = FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("/resources/themes/themes.json");
			//Lê o arquivo themes.json na String json
			String json = new String(Files.readAllBytes(Paths.get(path)));
			//Desserializa  a String json no List<Theme>
			themes = Arrays.asList(new Gson().fromJson(json, Theme[].class));
			//Pega o nome do primeiro Theme contido no List
			//Esse será o Theme padrão ao iniciar a aplicação
			theme = themes.get(0).getName();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public List<Theme> getThemes() {
		return themes;
	}


	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

}