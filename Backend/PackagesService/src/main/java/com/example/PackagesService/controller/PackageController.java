package com.example.PackagesService.controller;

import com.example.PackagesService.payload.PackageDTO;
import com.example.PackagesService.service.impl.PackageServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("packages")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PackageController {

    private final PackageServiceImpl packageService;

    @GetMapping("/{packgeID}")
    public PackageDTO getByPackageID(@PathVariable(value = "packgeID") Long packageID){
        return packageService.getById(packageID);
    }
    @GetMapping("/package/{packageName}")
    public List<PackageDTO> getByName(@PathVariable(value = "packageName") String packageName){
        return packageService.getByPackageName(packageName);
    }
    @PostMapping()
    public ResponseEntity<PackageDTO> createPackage(@Valid @RequestBody PackageDTO packageDTO){
        return new ResponseEntity<>(packageService.createPackage(packageDTO), HttpStatus.CREATED);
    }
}
