package myapp.securityConfig;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import myapp.javaObjects.Person;
import myapp.javaObjects.Role;
import myapp.dao.PersonDao;

@Service
public class MyUserDetails implements UserDetailsService {

  @Autowired
  private PersonDao personDao;

  @Override
  public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
     Person person  = personDao.findByfirstName(firstName);
    List<Role> l = new ArrayList<>();
    l.add(Role.ROLE_ADMIN);
    person.setRoles(l);
   
    if (person == null) {
      throw new UsernameNotFoundException("person '" + firstName + "' not found");
    
    }
    System.out.println(person.getRoles());
    return org.springframework.security.core.userdetails.User//
        .withUsername(firstName)
        .password(person.getPassword())
        .authorities(person.getRoles())
        .accountExpired(false)
        .accountLocked(false)
        .credentialsExpired(false)
        .disabled(false)
        .build();
  }

}