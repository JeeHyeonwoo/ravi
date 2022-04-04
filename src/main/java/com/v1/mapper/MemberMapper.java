package com.v1.mapper;

import com.v1.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    MemberDTO findByName(Long id);
}
