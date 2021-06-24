package br.com.zup.transacao.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.trasacao.Transacao;
import br.com.zup.transacao.trasacao.DTO.TransacaoDTO;

@Component
public class ConsomeMensagensTransacao {

	@KafkaListener(topics = "transacoes", groupId = "aplicacao-transacao")
	public void pegaMensagens(TransacaoDTO trasancaoDTO) {
		
		Transacao transacao = trasancaoDTO.converte();
		
		System.out.println(transacao.toString());
	}
}
