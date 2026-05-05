package com.khang.day1.service;

import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Parent;
import com.khang.day1.dto.parent.ParentInsertRequest;
import com.khang.day1.dto.parent.ParentResponse;
import com.khang.day1.dto.parent.ParentUpdateRequest;

import java.util.List;

public interface ParentService {
    List<ParentResponse> findAll();

    ParentResponse findById(Long id);

    ParentResponse save(ParentInsertRequest parent);

    ParentResponse update(Long id, ParentUpdateRequest parent) throws NotFoundException;

    void deleteById(Long id) throws NotFoundException;
}
