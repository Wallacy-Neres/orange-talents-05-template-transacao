package br.com.zup.transacao.cartao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String>{
	
	public Optional<Cartao> findById(String id);
}
