package br.com.mouawad.estudos.spring01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mouawad.estudos.spring01.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
