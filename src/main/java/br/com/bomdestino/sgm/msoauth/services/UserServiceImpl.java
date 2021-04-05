package br.com.bomdestino.sgm.msoauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bomdestino.sgm.msoauth.exceptions.NotFoundException;
import br.com.bomdestino.sgm.msoauth.feignclients.UserFeignClient;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	private final UserFeignClient userFeignClient;
	
	@Autowired
	public UserServiceImpl(UserFeignClient userFeignClient) {
		this.userFeignClient = userFeignClient;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		try {
			return userFeignClient.findByEmail(email).getBody();
		} catch (Exception e) {
			throw new NotFoundException(e.getMessage(), e.getCause());
		}
		
		
	}

}
