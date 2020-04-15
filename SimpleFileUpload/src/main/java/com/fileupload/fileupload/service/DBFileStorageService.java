package com.fileupload.fileupload.service;

import com.fileupload.fileupload.exception.FileStorageException;
import com.fileupload.fileupload.exception.MyFileNotFoundException;
import com.fileupload.fileupload.model.DBFile;
import com.fileupload.fileupload.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DBFileStorageService {
    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file,String title){
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry filename contains invalid path sequence"+fileName);

            }
            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes(),title);
            return dbFileRepository.save(dbFile);
        }catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public DBFile getFile(String fileId){
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    public List<DBFile> getTitle(){
        return dbFileRepository.findAll();
    }
}
