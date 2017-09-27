package org.ksusha.security;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ksusha.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    //get user from the database, via Hibernate
    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        org.ksusha.entities.User user = userRepository.findByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);

    }


    private User buildUserForAuthentication(org.ksusha.entities.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(),
                true, true,
                true, true, authorities);
        // todo later add enable
    }

    private List<GrantedAuthority> buildUserAuthority(List<String> userRoles) {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        // Build user's authorities
        for (String nameRole : userRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(nameRole));
        }

        return new ArrayList<GrantedAuthority>(grantedAuthorities);
    }

}