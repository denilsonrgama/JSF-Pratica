package br.com.fiapon.imoveis.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TBL_IMV_SOLICITACAO")
@SequenceGenerator(name="sqSolicitacao", 
sequenceName="SEQ_SOLICITACAO", allocationSize=1)
public class Solicitacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqSolicitacao")	
	@Column(name = "cd_solicitacao")
	private int codigo;
	
	@Column(name = "nm_cidade")
	private String cidade;
	
	@Column(name = "ds_tipo")
	private String tipo;
	
	@Column(name = "ds_operacao")
	private String operacao;
	
	@Column(name = "ds_finalidade")
	private String finalidade;
	
	@Column(name = "vl_operacao")
	private float valor;
	
	@Column(name = "ds_imovel")
	private String descricao;
	
	@org.hibernate.annotations.Type(type="yes_no")
	@Column(name = "st_novo")
	private boolean novo;
	
	@ElementCollection
	@Column(name = "ds_itens")
	private List<String> itens;



	@ElementCollection
	@Column(name = "ds_comodos")
	private List<String> comodos;

	
	@Column(name = "vl_senha")
	private String senha;
	

	@Column(name = "ds_email")
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_solicitacao")
	private Calendar dataSolicitacao;

	public Solicitacao() {
		//Inicializa a data de solicitação
		dataSolicitacao= Calendar.getInstance();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}

	public List<String> getComodos() {
		return comodos;
	}

	public void setComodos(List<String> comodos) {
		this.comodos = comodos;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	@Override
	public String toString() {
		return "Solicitacao [codigo=" + codigo + ", cidade=" + cidade + ", tipo=" + tipo + ", operacao=" + operacao
				+ ", finalidade=" + finalidade + ", valor=" + valor + ", descricao=" + descricao + ", novo=" + novo
				+ ", itens=" + itens + ", comodos=" + comodos + ", senha=" + senha + ", email=" + email
				+ ", dataSolicitacao=" + dataSolicitacao + "]";
	}
	
	
}