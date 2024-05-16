package br.com.cc.cleancut.repositories;

import br.com.cc.cleancut.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
