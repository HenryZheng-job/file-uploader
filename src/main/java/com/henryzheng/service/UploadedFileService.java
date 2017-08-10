package com.henryzheng.service;

import com.henryzheng.exception.FileNotFoundException;
import com.henryzheng.entity.UploadedFile;
import com.henryzheng.exception.FileUploadFailException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by HenryZheng on 8/9/17.
 */

public interface UploadedFileService {

    List<UploadedFile> findAllFiles();
    UploadedFile findFileById(Integer id) throws FileNotFoundException;
    UploadedFile uploadFile(MultipartFile f) throws FileUploadFailException;

}
