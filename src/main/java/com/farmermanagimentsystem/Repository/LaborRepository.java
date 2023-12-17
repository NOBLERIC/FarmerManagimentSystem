package com.farmermanagimentsystem.Repository;

import com.farmermanagimentsystem.Repository.Modal.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FarmerRepository extends  JpaRepository<Labor,String>{
}

