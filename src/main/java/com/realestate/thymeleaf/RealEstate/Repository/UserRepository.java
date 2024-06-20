package com.realestate.thymeleaf.RealEstate.Repository;

import com.realestate.thymeleaf.RealEstate.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData,Long> {

    @Query("SELECT u.id FROM UserData u WHERE u.email = :email")
    Optional<Long> findIdByEmail(@Param("email") String email);
}
