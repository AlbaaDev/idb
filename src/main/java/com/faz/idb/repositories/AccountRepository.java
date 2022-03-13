/**
 * @author FAZLIU Arber
 */
package com.faz.idb.repositories;

import com.faz.idb.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
