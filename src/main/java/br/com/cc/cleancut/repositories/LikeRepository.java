package br.com.cc.cleancut.repositories;

import br.com.cc.cleancut.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Long countLikesByImageId(Long imageId);

}
