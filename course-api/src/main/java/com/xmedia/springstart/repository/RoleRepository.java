package com.xmedia.springstart.repository;

import com.xmedia.springstart.model.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r.name FROM Role r WHERE r.name = ?1")
    String findName(String name);

    @Query("SELECT r.id FROM Role r WHERE r.id=?1")
    String findId(int id);

}
