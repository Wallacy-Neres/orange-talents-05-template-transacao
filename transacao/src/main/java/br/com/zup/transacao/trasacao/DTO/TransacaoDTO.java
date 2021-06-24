package br.com.zup.transacao.trasacao.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import br.com.zup.transacao.trasacao.Transacao;

public class TransacaoDTO {
	
	private String id;
	
	private BigDecimal valor;
	
	
	private Estabelecimento estabelecimento;
	
	
	private Cartao cartao;
	
	@Deprecated
	public TransacaoDTO() {
		
	}
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime efetivadaEm;

	public TransacaoDTO(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}
	
	public Transacao converte() {
		return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	
}
