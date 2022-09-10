package com.lastcivilization.userwriteservice.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserJpaRepository extends JpaRepository<UserEntity, Long> { }
