package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;

@Service
public class MembershipTypeService {

    private final MembershipTypeRepository repo;

    public MembershipTypeService(MembershipTypeRepository repo) {
        this.repo = repo;
    }

    public MembershipType createMembershipType(MembershipType type) {
        return repo.save(type);
    }

    public MembershipType getMembershipTypeById(long id) {
        return repo.findById(id).orElse(null); // controller handles 404
    }

    public MembershipType updateMembershipType(long id, MembershipType updatedType) {
        return repo.findById(id).map(type -> {
            type.setTypeName(updatedType.getTypeName());
            type.setPrice(updatedType.getPrice());
            type.setDurationInMonths(updatedType.getDurationInMonths());
            return repo.save(type);
        }).orElse(null); // null → controller returns 404
    }

    public List<MembershipType> getAllMembershipTypes() {
        return repo.findAll();
    }
public List<MembershipType> getMembershipTypesByName(String name) {
    return repo.findByTypeName(name);
}

public List<MembershipType> getMembershipTypesByPriceRange(double min, double max) {
    return repo.findByPriceRange(min, max);
}

public List<MembershipType> getMembershipTypesByDurationGreaterThan(int months) {
    return repo.findByDurationGreaterThan(months);
}
public List<MembershipType> getMembershipTypesByPriceLessThan(double price) {
    return repo.findByPriceLessThan(price);
}


}
