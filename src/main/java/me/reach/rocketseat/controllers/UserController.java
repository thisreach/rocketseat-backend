package me.reach.rocketseat.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import me.reach.rocketseat.models.UserModel;
import me.reach.rocketseat.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository repository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel model) {
        var user = this.repository.findByUsername(model.getUsername());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O usuário já existe");
        }

        var passwordHashed = BCrypt.withDefaults().hashToString(12, model.getPassword().toCharArray());

        model.setPassword(passwordHashed);

        var created = this.repository.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
