package com.example.demo.config;

/*import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/

/*@Service
@EnableWebSecurity*/
public class UserDetailsService /*implements org.springframework.security.core.userdetails.UserDetailsService*/ {
  /*  @Autowired
    private UserService userService;

    public UserDetailsService(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user  = userService.getUserByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(RolesOfUsers roleOfPerson:user.getAuthority()){
            authorities.add(new SimpleGrantedAuthority(roleOfPerson.getRole_name()));
        }
        return authorities;
    }*/
}
