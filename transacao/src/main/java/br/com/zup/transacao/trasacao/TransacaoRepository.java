package br.com.zup.transacao.trasacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	@Query("Select c from Transacao c where c.cartao.id =:cartao")
	public Page<Transacao> findCartaoTransacao(@Param("cartao") String cartao, Pageable paginacao);
	
	
	
}
