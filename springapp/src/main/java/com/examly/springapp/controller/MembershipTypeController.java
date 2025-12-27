package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.service.MembershipTypeService;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

    private final MembershipTypeService service;

    public MembershipTypeController(MembershipTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MembershipType> createMembershipType(@RequestBody MembershipType type) {
        try {
            MembershipType saved = service.createMembershipType(type);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipType> getMembershipTypeById(@PathVariable long id) {
        MembershipType type = service.getMembershipTypeById(id);
        if (type != null) {
            return ResponseEntity.status(HttpStatus.OK).body(type);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipType> updateMembershipType(
            @PathVariable long id,
            @RequestBody MembershipType updatedType) {

        MembershipType type = service.updateMembershipType(id, updatedType);
        if (type != null) {
            return ResponseEntity.status(HttpStatus.OK).body(type);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MembershipType>> getAllMembershipTypes() {
        try {
            List<MembershipType> types = service.getAllMembershipTypes();
            return ResponseEntity.status(HttpStatus.OK).body(types);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
@GetMapping("/name/{typeName}")
    public ResponseEntity<Object> getMembershipTypesByName(@PathVariable String typeName) {
        List<MembershipType> types = service.getMembershipTypesByName(typeName);
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(types);
    }


@GetMapping("/price")
public ResponseEntity<List<MembershipType>> getMembershipTypesByPriceRange(
        @RequestParam double min,
        @RequestParam double max) {

    List<MembershipType> types = service.getMembershipTypesByPriceRange(min, max);
    return ResponseEntity.status(HttpStatus.OK).body(types);
}

    @GetMapping("/duration-greater/{months}")
    public ResponseEntity<Object> getMembershipTypesByDurationGreaterThan(@PathVariable int months) {
        List<MembershipType> types = service.getMembershipTypesByDurationGreaterThan(months);
        
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No membership types found with duration greater than " + months);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(types);
    }

    @GetMapping("/price-less/{price}")
    public ResponseEntity<Object> getMembershipTypesByPriceLessThan(@PathVariable double price) {
        List<MembershipType> types = service.getMembershipTypesByPriceLessThan(price);
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(types);
    }


}
