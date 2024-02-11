package com.topicoses.filesservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="t_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    private static final int blobSize = 1024 * 1024 * 25; //26214400 or 25MB
    @Lob
    @Column(length = blobSize)
    private byte[] data;
}
