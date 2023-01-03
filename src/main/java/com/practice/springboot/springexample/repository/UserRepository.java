package com.practice.springboot.springexample.repository;

import com.practice.springboot.springexample.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Query(value = "SELECT u FROM users u WHERE u.email=?1", nativeQuery = true)
    ResultSet findByUserEmail(String email);

    @Query(value = "SELECT u FROM users u WHERE u.name like ?1%", nativeQuery = true)
    List<ResultSet> findByNameAndSort(String email, Sort sort);
}
