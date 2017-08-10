package com.henryzheng.service;

import com.henryzheng.dao.UploadedFileRepository;
import com.henryzheng.entity.UploadedFile;
import com.henryzheng.exception.FileNotFoundException;
import com.henryzheng.exception.FileUploadFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by HenryZheng on 8/9/17.
 */

@Service
public class UploadedFileServiceImpl implements UploadedFileService {

    static final String LOCAL_PATH = "uploadedFiles/";

    @Autowired
    UploadedFileRepository uploadedFileRepository;

    @Transactional
    @Override
    public List<UploadedFile> findAllFiles() {
        return uploadedFileRepository.findAll();
    }

    @Transactional
    @Override
    public UploadedFile findFileById(Integer id) throws FileNotFoundException{
        UploadedFile f = uploadedFileRepository.findOne(id);
        if (f == null) {
            throw new FileNotFoundException("File ID is not recorded in the database!!");
        }
        return f;
    }

    @Transactional
    @Override
    public UploadedFile uploadFile(MultipartFile f) throws FileUploadFailException {

        Path dir = Paths.get(LOCAL_PATH).toAbsolutePath();
        Long curTime = System.currentTimeMillis();
        String fileName = curTime + "_" + f.getOriginalFilename();
        String fileLocation = dir.toString()+ File.separator + fileName;

        UploadedFile newFile = new UploadedFile();
        newFile.setFileName(fileName);
        newFile.setFileLocation(LOCAL_PATH + fileName);
        newFile.setFileSize(f.getSize());
        newFile.setCreatedAt(curTime);

        try {
            f.transferTo(new File(fileLocation));
        } catch (IOException e) {
            throw new FileUploadFailException("faied to store the file on the server!");
        }
        return uploadedFileRepository.save(newFile);
    }
}
