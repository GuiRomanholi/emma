package br.com.fiap.emma.controller;

import br.com.fiap.emma.dto.AuthDTO;
import br.com.fiap.emma.dto.LoginResponseDTO;
import br.com.fiap.emma.dto.RegisterDTO;
import br.com.fiap.emma.model.Person;
import br.com.fiap.emma.model.UserRole;
import br.com.fiap.emma.repository.PersonRepository;
import br.com.fiap.emma.service.PersonService;
import br.com.fiap.emma.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO authDTO) {
        var userPwd = new UsernamePasswordAuthenticationToken(
                authDTO.email(),
                authDTO.senha()
        );
        var auth = this.authenticationManager.authenticate(userPwd);
        var token = tokenService.generateToken((Person) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (personRepository.findByEmail(registerDTO.email()) != null) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");
        }

        UserRole role;
        if (registerDTO.role() == null || registerDTO.role().isEmpty() || registerDTO.role().equalsIgnoreCase("USER")) {
            role = UserRole.USER;
        } else if (registerDTO.role().equalsIgnoreCase("ADMIN")) {
            role = UserRole.ADMIN;
        } else {
            return ResponseEntity.badRequest().body("Role inválida. Use 'USER' ou 'ADMIN'.");
        }

        String encryptedPassword = passwordEncoder.encode(registerDTO.senha());

        Person newPerson = new Person(
                registerDTO.name(),
                registerDTO.email(),
                encryptedPassword,
                role
        );

        try {
            personService.save(newPerson);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}