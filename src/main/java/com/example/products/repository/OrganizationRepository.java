package com.example.products.repository;

import com.example.products.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByName(String name);
    @Transactional
    @Modifying
    @Query("update Organization org set org.isActive = :val where id = :id")
    int setIsActive(@Param("id") Long organizationId, @Param("val") boolean val);


}