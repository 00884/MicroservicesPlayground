package com.itimoshin.spring_cloud_mastering.auth.domain.user;

import com.itimoshin.spring_cloud_mastering.auth.domain.role.GrantedAuthorityImpl;
import com.itimoshin.spring_cloud_mastering.auth.domain.role.RoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DbUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DbUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Mono<UserEntity> userMono = userRepository.findByUsername(username);
        Mono<List<GrantedAuthority>> rolesMono = userMono
                .map(user -> roleRepository.findRolesByUserId(user.getId()))
                .map(roles -> roles.map(role -> (GrantedAuthority)new GrantedAuthorityImpl(role.getName())))
                .flatMap(Flux::collectList);

        return userMono.zipWith(rolesMono).map(tuple -> new UserDetailsImpl(tuple.getT1().getUsername(), tuple.getT1().getPassword(), tuple.getT2())).block();
    }
}
