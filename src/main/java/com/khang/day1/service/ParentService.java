package com.khang.day1.service;

import com.khang.day1.domain.entity.Parent;

import java.util.List;

public interface ParentService {
    List<Parent> findAll();

    Parent findById(Long id);

    Parent save(Parent parent);

    Parent update(Long id, Parent parent);

    void deleteById(Long id);
}
