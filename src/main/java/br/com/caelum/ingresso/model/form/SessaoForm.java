package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {

	@NotNull
	private Integer salaId;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private Integer filmeId;

	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		
		Filme filme = filmeDao.findOne(filmeId);
		Sala sala = salaDao.findOne(salaId);
		
		Sessao sessao = new Sessao (this.horario, filme, sala);
		
		return sessao;
	}

	/**
	 * @return the salaId
	 */
	public Integer getSalaId() {
		return salaId;
	}

	/**
	 * @param salaId the salaId to set
	 */
	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	/**
	 * @return the horario
	 */
	public LocalTime getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	/**
	 * @return the filmeId
	 */
	public Integer getFilmeId() {
		return filmeId;
	}

	/**
	 * @param filmeId the filmeId to set
	 */
	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

}
