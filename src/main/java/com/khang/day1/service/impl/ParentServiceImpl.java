package com.khang.day1.service.impl;

import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Parent;
import com.khang.day1.dto.parent.ParentInsertRequest;
import com.khang.day1.dto.parent.ParentResponse;
import com.khang.day1.dto.parent.ParentUpdateRequest;
import com.khang.day1.repository.ParentRepository;
import com.khang.day1.service.ParentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ParentResponse> findAll() {
        return parentRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    @Override
    public ParentResponse findById(Long id) {
        return modelMapper.map(parentRepository.findById(id), ParentResponse.class);
    }

    @Override
    public ParentResponse save(ParentInsertRequest parent) {
        return  modelMapper.map(parentRepository.save(modelMapper.map(parent, Parent.class)), ParentResponse.class);
    }

    @Override
    public ParentResponse update(Long id, ParentUpdateRequest parent) {
        Parent existingParent = parentRepository.findById(id).orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        modelMapper.map(parent, existingParent);
        return modelMapper.map(parentRepository.save(existingParent), ParentResponse.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        parentRepository.deleteById(id);
    }

    private ParentResponse map(Parent parent) {
        return modelMapper.map(parent, ParentResponse.class);
    }
}
