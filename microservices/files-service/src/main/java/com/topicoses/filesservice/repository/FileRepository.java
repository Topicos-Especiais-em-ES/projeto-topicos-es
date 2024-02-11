package com.topicoses.filesservice.repository;

import com.topicoses.filesservice.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {

    @Query("SELECT new com.topicoses.filesservice.repository.AllFilesProjection(f.id, f.name, f.type) FROM File f")
    List<AllFilesProjection> findAllWithoutData();
}
