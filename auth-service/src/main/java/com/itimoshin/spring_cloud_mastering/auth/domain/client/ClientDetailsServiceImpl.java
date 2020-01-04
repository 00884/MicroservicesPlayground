package com.itimoshin.spring_cloud_mastering.auth.domain.client;

import com.itimoshin.spring_cloud_mastering.auth.domain.grant_type.GrantTypeEntity;
import com.itimoshin.spring_cloud_mastering.auth.domain.grant_type.GrantTypeRepository;
import com.itimoshin.spring_cloud_mastering.auth.domain.scope.ScopeEntity;
import com.itimoshin.spring_cloud_mastering.auth.domain.scope.ScopeRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private final ClientRepository clientRepository;
    private final GrantTypeRepository grantTypeRepository;
    private final ScopeRepository scopeRepository;

    public ClientDetailsServiceImpl(ClientRepository clientRepository,
                                    GrantTypeRepository grantTypeRepository,
                                    ScopeRepository scopeRepository) {
        this.clientRepository = clientRepository;
        this.grantTypeRepository = grantTypeRepository;
        this.scopeRepository = scopeRepository;
    }

    @Override
    @Transactional
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Mono<ClientEntity> clientMono = clientRepository.findByClientName(clientId);
        Mono<List<String>> scopesMono = clientMono
                .map(clientEntity -> scopeRepository.findScopesByClientId(clientEntity.getId()))
                .map(scopes -> scopes.map(ScopeEntity::getName))
                .flatMap(Flux::collectList);
        Mono<List<String>> grantTypesMono = clientMono
                .map(cd -> grantTypeRepository.findGrantTypesByClientId(cd.getId()))
                .map(scopes -> scopes.map(GrantTypeEntity::getName))
                .flatMap(Flux::collectList);


        return Mono.zip(clientMono, scopesMono, grantTypesMono)
                .map(tuple -> new ClientDetailsImpl(
                        tuple.getT1().getClientName(),
                        tuple.getT1().getClientSecret(),
                        new HashSet<>(tuple.getT2()),
                        new HashSet<>(tuple.getT3()),
                        9999,
                        9999))
                .block();
    }
}
