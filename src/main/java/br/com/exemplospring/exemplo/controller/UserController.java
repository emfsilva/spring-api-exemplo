package br.com.exemplospring.exemplo.controller;

import br.com.exemplospring.exemplo.entity.User;
import br.com.exemplospring.exemplo.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Código de mensagens de retorno do swigger
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @GetMapping(produces = "application/json")
    public List<User> GetAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<User> GetById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(produces = "application/json")
    public User Post(@RequestBody @Valid User user) {
       return userService.save(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> change(@PathVariable @Valid Long id, @RequestBody User user) {
        if (userService.exist(id)) {
            userService.change(id, user);
            return ok(user);
        }
        return notFound().build();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        if (userService.exist(id)) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
