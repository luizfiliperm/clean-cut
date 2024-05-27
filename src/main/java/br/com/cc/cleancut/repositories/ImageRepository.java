package br.com.cc.cleancut.repositories;

import br.com.cc.cleancut.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT i.id FROM Image i WHERE i.user.id = :userId")
    List<Long> getAllIds(@Param("userId") Long userId);

    Long countImageByUserId(Long userId);

    @Query("SELECT COUNT(l) FROM Image i JOIN i.likes l WHERE i.user.id = :userId")
    Long countTotalLikes(Long userId);

    @Query("SELECT COUNT(d) FROM Image i JOIN i.downloads d WHERE i.user.id = :userId")
    Long countTotalDownloads(Long userId);
}
