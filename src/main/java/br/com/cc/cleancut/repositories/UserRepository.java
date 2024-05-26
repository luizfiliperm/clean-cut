package br.com.cc.cleancut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cc.cleancut.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Boolean existsByEmail(String email);

}
