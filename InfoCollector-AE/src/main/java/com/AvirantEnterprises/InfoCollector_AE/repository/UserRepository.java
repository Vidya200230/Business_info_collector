package com.AvirantEnterprises.InfoCollector_AE.repository;


import com.AvirantEnterprises.InfoCollector_AE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
