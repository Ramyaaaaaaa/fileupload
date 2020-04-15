package com.fileupload.fileupload.repository;

import com.fileupload.fileupload.model.DBFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends MongoRepository<DBFile,String> {

}
