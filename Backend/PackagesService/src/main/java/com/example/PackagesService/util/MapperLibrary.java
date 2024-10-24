package com.example.PackagesService.util;

import com.example.PackagesService.PackagesServiceApplication;
import com.example.PackagesService.entity.Package;
import com.example.PackagesService.entity.PackageItenary;
import com.example.PackagesService.payload.PackageDTO;
import com.example.PackagesService.payload.PackageItenaryDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperLibrary {
    public Package mapToPackage(PackageDTO packageDTO){
        return PackagesServiceApplication.modelMapper().map(packageDTO,Package.class);
    }

    public PackageDTO mapToPackageDTO(Package aPackage){
        return PackagesServiceApplication.modelMapper().map(aPackage,PackageDTO.class);
    }

    public PackageItenaryDTO mapToItenaryDTO(PackageItenary packageItenary){
        return PackagesServiceApplication.modelMapper().map(packageItenary,PackageItenaryDTO.class);
    }

    public PackageItenary mapToIntenary(PackageItenaryDTO packageItenaryDTO){
        return PackagesServiceApplication.modelMapper().map(packageItenaryDTO,PackageItenary.class);
    }
}
