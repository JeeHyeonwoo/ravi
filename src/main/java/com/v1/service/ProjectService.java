package com.v1.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService{
    List<byte[]> projectThumbnailCreate(int mount);
}
