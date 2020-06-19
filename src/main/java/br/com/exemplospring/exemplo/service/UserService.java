package br.com.exemplospring.exemplo.service;

import br.com.exemplospring.exemplo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(long id);
    User save(User user);
    void deleteById(Long id) throws Exception;
    List<User> findAll();
}
