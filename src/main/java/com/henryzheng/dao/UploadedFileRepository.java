package com.henryzheng.dao;

import com.henryzheng.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HenryZheng on 8/9/17.
 */
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Integer> {
}
