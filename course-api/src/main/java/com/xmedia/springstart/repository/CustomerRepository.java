package com.xmedia.springstart.repository;

import com.xmedia.springstart.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

    @Query("SELECT c.hotline FROM Customers c WHERE c.hotline=?1")
    String checkHotLine(String hotline);

    @Query("SELECT c.id FROM Customers c WHERE c.id=?1")
    Integer checkId(int id);
}
