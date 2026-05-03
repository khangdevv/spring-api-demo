package com.khang.day1.service.impl;

import com.khang.day1.domain.entity.Parent;
import com.khang.day1.repository.ParentRepository;
import com.khang.day1.service.ParentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;

    @Override
    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    @Override
    public Parent findById(Long id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent update(Long id, Parent parent) {
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));

        existingParent.setFullName(parent.getFullName());
        existingParent.setEmail(parent.getEmail());
        existingParent.setPhoneNumber(parent.getPhoneNumber());
        existingParent.setAddress(parent.getAddress());

        return parentRepository.save(existingParent);
    }

    @Override
    public void deleteById(Long id) {
        parentRepository.deleteById(id);
    }
}
