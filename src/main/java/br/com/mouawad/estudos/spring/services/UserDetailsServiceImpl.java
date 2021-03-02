package br.com.mouawad.estudos.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.Cliente;
import br.com.mouawad.estudos.spring.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente e = clienteService.findByEmail(email);
		if(e == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(e.getId(),e.getEmail(),e.getSenha(),e.getPerfis());
	}

}
