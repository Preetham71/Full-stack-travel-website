package com.example.PackagesService.service;

import com.example.PackagesService.payload.PackageItenaryDTO;

import java.util.List;

public interface PackageItenaryService {
    PackageItenaryDTO createItenary(PackageItenaryDTO packageItenaryDTO);
    List<PackageItenaryDTO> getAllByPackageId(Long packageId);
}
