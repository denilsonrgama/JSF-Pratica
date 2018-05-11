package br.com.fiapon.imoveis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiapon.imoveis.entity.Theme;
import br.com.fiapon.imoveis.service.ThemePreferenceService;

@Named
@SessionScoped
public class TrocaThemeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//atributo com a lista de temas
	private List<Theme> themes;
	//Atributo com o nome do tema corrente
	private String theme;
	
	@Inject //Assim o servidor cria um obj para o tp
	private ThemePreferenceService tp;

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public List<Theme> getThemes() {
		return themes;
	}
	
	@PostConstruct
	public void init() {
		//tp = new ThemePreferenceService(); // Com o  @Named, não há necessidade de instaciar este obj
		//Busca no service todos os temas carregados do json
		themes = tp.getThemes();
		//Busca do service o tema default
		theme = tp.getTheme();
	}
	
	public void saveTheme() {
		tp.setTheme(theme);
	}

}