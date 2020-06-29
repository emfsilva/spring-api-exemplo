package br.com.exemplospring.exemplo.service;

import java.util.List;
import java.util.Optional;

import br.com.exemplospring.exemplo.entity.User;

public interface UserService {

    void deleteById(Long id);
    List<User> findAll();
    boolean exist(Long id);
    Optional<User> findById(Long id);
    User regress(Long id);
    void change(Long id, User user);
    User save(User user);
}
