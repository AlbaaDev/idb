package com.faz.idb.repositories;

import com.faz.idb.models.Adviser;
import com.faz.idb.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdviserRepository extends AbstractUserRepository<Adviser> {
    Optional<Adviser> findByEmail(String email);
}
