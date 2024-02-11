package com.topicoses.filesservice.service;

import com.topicoses.filesservice.model.File;
import com.topicoses.filesservice.repository.AllFilesProjection;
import com.topicoses.filesservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public List<File> listAllFiles() {
        return fileRepository.findAll();
    }

    public List<AllFilesProjection> listAllFilesWithoutData() {
        return fileRepository.findAllWithoutData();
    }

    public Optional<File> getFileById(long id){
        return fileRepository.findById(id);
    }

    public void saveFile(MultipartFile file) throws IOException {
        File entityFile = new File();
        entityFile.setName(file.getOriginalFilename());
        entityFile.setType(file.getContentType());
        entityFile.setData(file.getBytes());
        fileRepository.save(entityFile);
    }

}
