package com.v1.mapper;

import com.v1.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<MemberDTO> findByName(Long id);
}
