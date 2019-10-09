package com.tp.api.service;

import com.tp.api.entities.User;
import com.tp.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    UserBuilder builder = null;

    if (user != null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      builder.password(user.getPassword());

      String[] roles = user.getRoles().stream().map(x -> x.getRoleName()).toArray(String[]::new);
      builder.roles(roles);
    } else {
      throw new UsernameNotFoundException("User not found.");
    }

    return builder.build();
  }

}
