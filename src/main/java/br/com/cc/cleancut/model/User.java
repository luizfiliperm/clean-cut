package br.com.cc.cleancut.model;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor // constructor com todos os atributos
@NoArgsConstructor // constructor vazio
@Data // getters e setters
@Entity // entidade no banco de dados
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Download> downloads;
    
    @OneToMany(mappedBy = "user")
    private List<Like> likes;

}
