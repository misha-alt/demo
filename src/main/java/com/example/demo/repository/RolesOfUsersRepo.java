package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.RolesOfUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesOfUsersRepo extends JpaRepository<RolesOfUsers, Long> {
    List<RolesOfUsers> findByRolename(String rolNam);
}
