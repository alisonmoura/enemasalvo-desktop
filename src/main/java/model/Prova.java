package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="prova")
public class Prova {

	@Id
	@SequenceGenerator(name="seq_prova", sequenceName="seq_prova", initialValue=1, allocationSize=50)
	@GeneratedValue(generator="seq_prova", strategy=GenerationType.AUTO)
	private Integer id;
	private Boolean buscada;
	private String nome;
	@OneToMany(mappedBy="prova", fetch=FetchType.EAGER)
	private List<Questao> questoes;
	
	public boolean valida(){
		return true;
	}
	
	public List<Questao> buscarQuestoes(){
		return new ArrayList<Questao>();
	}
	
	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBuscada() {
		return buscada;
	}

	public void setBuscada(Boolean buscada) {
		this.buscada = buscada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buscada == null) ? 0 : buscada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prova other = (Prova) obj;
		if (buscada == null) {
			if (other.buscada != null)
				return false;
		} else if (!buscada.equals(other.buscada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
