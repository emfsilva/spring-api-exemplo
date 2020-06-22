package br.com.exemplospring.exemplo.service;

import br.com.exemplospring.exemplo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void deleteById(Long id);
    List<User> findAll();
    boolean exist(Long id);
    Optional<User> findById(Long id);
    User regress(Long id);
    void change(Long id, User user);
    User save(User user);
}
