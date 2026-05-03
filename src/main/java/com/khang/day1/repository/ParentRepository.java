package com.khang.day1.repository;

import com.khang.day1.domain.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {
}
