package br.com.exemplospring.exemplo.repository;

import br.com.exemplospring.exemplo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
