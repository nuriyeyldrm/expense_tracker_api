package com.expensetracker.repository;

import com.expensetracker.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Users u " +
            "SET u.enabled = TRUE WHERE u.email =?1")
    int enableAppUser(String email);
}
