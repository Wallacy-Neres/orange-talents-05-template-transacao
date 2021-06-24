package br.com.zup.transacao.trasacao.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zup.transacao.estabelecimento.Estabelecimento;
import br.com.zup.transacao.trasacao.Transacao;

public class TransacaoResponse {

	private BigDecimal valor;

	private Estabelecimento estabelecimento;

	private String cartao;
	
	private LocalDateTime efetivadaEm;

	public TransacaoResponse(Transacao transacao) {
		super();
		this.valor = transacao.getValor();
		this.estabelecimento = transacao.getEstabelecimento();
		this.cartao = transacao.getCartao().getId();
		this.efetivadaEm = transacao.getEfetivadaEm();
	}
	
	public static Page<TransacaoResponse> converte(Page<Transacao> transacao) {
		return transacao.map(TransacaoResponse::new);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public String getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	
}
