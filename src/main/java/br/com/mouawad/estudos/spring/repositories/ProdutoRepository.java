package br.com.mouawad.estudos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mouawad.estudos.spring.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> { // <classe,id>

}
