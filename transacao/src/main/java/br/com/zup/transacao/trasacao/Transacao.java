package br.com.zup.transacao.trasacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;

@Entity
public class Transacao {
	
	@Id
	private String id;
	
	private BigDecimal valor;
	
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Transacao() {
		
	}
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime efetivadaEm;

	public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
	
	
}
