package com.example.PackagesService.service;

import com.example.PackagesService.entity.Package;
import com.example.PackagesService.payload.PackageDTO;

import java.util.List;

public interface PackageService {
    PackageDTO createPackage(PackageDTO packageDTO);
    List<PackageDTO> getByPackageName(String name);
    PackageDTO getById(Long packageID);
}
