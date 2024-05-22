package br.com.cc.cleancut.model;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    private Boolean isPrivate;

    @OneToMany
    private List<Image> images;

    @OneToMany(mappedBy = "image")
    private List<Like> likes;

}
