package com.khang.day1.mapper;

import com.khang.day1.domain.entity.Parent;
import com.khang.day1.dto.parent.ParentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    ParentResponse toParentResponse(Parent parent);
    List<ParentResponse> toParentResponseList(List<Parent> parents);
}
