package br.com.zup.transacao.trasacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.transacao.trasacao.DTO.TransacaoResponse;
import javassist.NotFoundException;



@RestController
@RequestMapping("transacoes")
public class TransacaoController {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping("{id}")
	public Page<TransacaoResponse> buscaTransacoes(@PathVariable String id,
			@PageableDefault(page = 0, size = 10) Pageable paginacao){
		Page<Transacao> transacao = transacaoRepository.findCartaoTransacao(id, paginacao);
		System.out.println(transacao);

		if (transacao.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return TransacaoResponse.converte(transacao);
	}
}
