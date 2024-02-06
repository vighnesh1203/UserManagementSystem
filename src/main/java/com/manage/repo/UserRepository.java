package com.manage.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
