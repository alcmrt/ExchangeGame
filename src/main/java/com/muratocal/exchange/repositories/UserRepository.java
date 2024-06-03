package com.muratocal.exchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muratocal.exchange.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
