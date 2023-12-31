package com.example.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dogbackend.domain.Kayttaja;
import com.example.dogbackend.domain.KayttajaRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final KayttajaRepository repository;
	
	@Autowired
	public UserDetailsServiceImpl(KayttajaRepository kRepository) {
		this.repository = kRepository;
	}
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	    {   
	    	Kayttaja curruser = repository.findByusername(username);
	        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
	        		AuthorityUtils.createAuthorityList(curruser.getRooli()));
	        return user;
	    }   
	
}
