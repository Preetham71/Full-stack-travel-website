package com.example.PackagesService.repository;

import com.example.PackagesService.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PacakgeRepository extends JpaRepository<Package,Long> {

    List<Package> findByPackageCountry(String packageCountry);
}
