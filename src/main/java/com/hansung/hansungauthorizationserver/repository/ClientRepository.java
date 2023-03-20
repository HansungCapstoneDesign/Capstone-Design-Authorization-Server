package com.hansung.hansungauthorizationserver.repository;

import com.hansung.hansungauthorizationserver.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.clientId =:clientId") // non-mandatory, 가독성을 위해 ...
    Optional<Client> findByClientId(String clientId);

}
