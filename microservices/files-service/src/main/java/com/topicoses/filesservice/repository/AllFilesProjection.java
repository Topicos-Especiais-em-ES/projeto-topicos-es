package com.topicoses.filesservice.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AllFilesProjection {
    private Long id;
    private String nome;
    private String tipo;
}
