package br.com.zup.transacao.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.trasacao.Transacao;
import br.com.zup.transacao.trasacao.TransacaoRepository;
import br.com.zup.transacao.trasacao.DTO.TransacaoRequest;

@Component
public class ConsomeMensagensTransacao {
	
	@Autowired
	private TransacaoRepository transacaoRepository;

	@KafkaListener(topics = "transacoes", groupId = "aplicacao-transacao")
	public void pegaMensagens(TransacaoRequest trasancaoDTO) {
		
		Transacao transacao = trasancaoDTO.converte();
		
		transacaoRepository.save(transacao);
		
		System.out.println(transacao.toString());
	}
}
