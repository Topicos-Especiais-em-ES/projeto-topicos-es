package com.topicoses.filesservice.controller;

import com.topicoses.filesservice.model.File;
import com.topicoses.filesservice.repository.AllFilesProjection;
import com.topicoses.filesservice.service.FileService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping
    public List<AllFilesProjection> listFiles() {
        return fileService.listAllFilesWithoutData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable Long id) {
        Optional<File> optionalFile = fileService.getFileById(id);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
                    .body(file.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void saveFile(@RequestParam("file") @NotNull MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            // Change this exception to specific
            throw new IOException("File is empty");
        }
        fileService.saveFile(file);
    }
}
