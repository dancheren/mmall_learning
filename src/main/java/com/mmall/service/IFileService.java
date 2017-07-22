package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 76911 on 2017/7/15.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
