package com.example.PackagesService.repository;

import com.example.PackagesService.entity.PackageItenary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PackageItenaryRepository extends JpaRepository<PackageItenary,String> {
    //@Query("select * from packageItenary where packageid=?1")
    //List<PackageItenary> getAllPackages(Long packageId);
}
