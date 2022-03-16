package com.faz.idb.repositories;

import com.faz.idb.models.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/

@Repository
@NoRepositoryBean
public interface AbstractUserRepository<T extends AbstractUser> extends JpaRepository<T, Long> {
    Optional<T> findByEmail(String email);
}
