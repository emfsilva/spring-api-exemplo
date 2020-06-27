package br.com.exemplospring.exemplo.service.serviceImpl;

import br.com.exemplospring.exemplo.entity.User;
import br.com.exemplospring.exemplo.repository.UserRepository;
import br.com.exemplospring.exemplo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean exist(Long id){
        return userRepository.existsById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
            return userRepository.findById(id);
        }

    @Override
    public User regress(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void change(Long id, User user) {
        User userChange = this.regress(id);
        userChange.setName(user.getName());
        userChange.setEmail(user.getEmail());
        this.save(userChange);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
