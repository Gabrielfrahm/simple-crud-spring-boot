package com.github.gabrielFrahm.cars.controllers;


import com.github.gabrielFrahm.cars.dtos.CreateUserData;
import com.github.gabrielFrahm.cars.dtos.UserLoginData;
import com.github.gabrielFrahm.cars.models.User;
import com.github.gabrielFrahm.cars.repositories.UserRepository;
import com.github.gabrielFrahm.cars.services.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenService tokenService;
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Validated UserLoginData data){
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
    var auth = this.authenticationManager.authenticate(usernamePassword);
    var token = tokenService.generateToken((User) auth.getPrincipal());
    return ResponseEntity.ok(new UserLoginData.UserLoginDataResponse(token));
  }

  @PostMapping
  public ResponseEntity create(@RequestBody @Validated CreateUserData data) {
    if(this.userRepository.findByEmail(data.getEmail()) != null) {
      return ResponseEntity.badRequest().build();
    }
    String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
    User newUser = new User(data.getEmail(), encryptedPassword, data.getRole());
    this.userRepository.save(newUser);
    return ResponseEntity.ok().build();
  }
}
