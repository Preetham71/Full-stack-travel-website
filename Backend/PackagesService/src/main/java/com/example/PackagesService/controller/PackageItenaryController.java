package com.example.PackagesService.controller;


import com.example.PackagesService.entity.PackageItenary;
import com.example.PackagesService.payload.PackageItenaryDTO;
import com.example.PackagesService.repository.PackageItenaryRepository;
import com.example.PackagesService.service.impl.PackageItenaryServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("packages/{packageId}/itenary")
@AllArgsConstructor
public class PackageItenaryController {
    private  final PackageItenaryServiceImpl packageItenaryService;

    @PostMapping()
    public ResponseEntity<PackageItenaryDTO> createItenary(@Valid @RequestBody PackageItenaryDTO packageItenaryDTO,
                                                           @PathVariable(value = "packageId") Long packageId){
        packageItenaryDTO.setPackageID(packageId);
        return new ResponseEntity<>(packageItenaryService.createItenary(packageItenaryDTO), HttpStatus.CREATED);
    }
}
