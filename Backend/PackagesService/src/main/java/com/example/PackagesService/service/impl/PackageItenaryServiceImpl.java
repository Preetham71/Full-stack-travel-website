package com.example.PackagesService.service.impl;

import com.example.PackagesService.entity.Package;
import com.example.PackagesService.entity.PackageItenary;
import com.example.PackagesService.exception.ResourceNotFoundException;
import com.example.PackagesService.payload.PackageItenaryDTO;
import com.example.PackagesService.repository.PacakgeRepository;
import com.example.PackagesService.repository.PackageItenaryRepository;
import com.example.PackagesService.service.PackageItenaryService;
import com.example.PackagesService.util.MapperLibrary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PackageItenaryServiceImpl implements PackageItenaryService {

    private final PackageItenaryRepository packageItenaryRepository;
    private final MapperLibrary mapperLibrary;
    private final PacakgeRepository packageRepository;
    @Override
    public PackageItenaryDTO createItenary(PackageItenaryDTO packageItenaryDTO) {
        Package aPackage = packageRepository.findById(packageItenaryDTO.getPackageID())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Package","id",packageItenaryDTO.getPackageID())
                );

        PackageItenary packageItenary = mapperLibrary.mapToIntenary(packageItenaryDTO);
        packageItenary.setAPackage(aPackage);
        return mapperLibrary.mapToItenaryDTO(
                packageItenaryRepository.save(packageItenary)
        );
    }

    @Override
    public List<PackageItenaryDTO> getAllByPackageId(Long packageId) {
        return List.of();
    }
}
