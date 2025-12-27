package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examly.springapp.model.MembershipType;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {

    
    @Query("SELECT m FROM MembershipType m WHERE m.typeName = :typeName")
    List<MembershipType> findByTypeName(@Param("typeName") String typeName);

    @Query("SELECT m FROM MembershipType m WHERE m.price BETWEEN :min AND :max")
    List<MembershipType> findByPriceRange(@Param("min") double min, @Param("max") double max);

    @Query("SELECT m FROM MembershipType m WHERE m.durationInMonths > :months")
    List<MembershipType> findByDurationGreaterThan(@Param("months") int months);

    List<MembershipType> findByPriceLessThan(double price);

}
