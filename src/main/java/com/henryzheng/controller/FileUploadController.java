package com.henryzheng.controller;

import com.henryzheng.exception.FileNotFoundException;
import com.henryzheng.entity.UploadedFile;
import com.henryzheng.exception.FileUploadFailException;
import com.henryzheng.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by HenryZheng on 8/9/17.
 */

@RestController
public class FileUploadController {

    @Autowired
    UploadedFileService uploadedFileService;

    @GetMapping(path="/files")
    public List<UploadedFile> getFiles() {
        return uploadedFileService.findAllFiles();
    }

    @GetMapping(path="/files/{id}")
    public UploadedFile getFile(@PathVariable Integer id) throws FileNotFoundException {
        return uploadedFileService.findFileById(id);
    }

    @PostMapping(path="/files")
    public UploadedFile uploadFile(@RequestParam MultipartFile file) throws FileUploadFailException {
        return uploadedFileService.uploadFile(file);
    }

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FileUploadFailException.class)
    public String fileUploadFileExceptionHandler(Exception e){
        return "ERROR: File uploaded failed! " + e.getMessage();
    }

    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(FileNotFoundException.class)
    public String fileNotFoundExceptionHandler(Exception e) {
        return "ERROR: File not found!\n" + e.getMessage();
    }
}