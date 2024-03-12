package com.perficient.shoppingcart.ShoppingCart.service.auth;

import com.perficient.shoppingcart.ShoppingCart.domain.security.Role;
import com.perficient.shoppingcart.ShoppingCart.domain.security.User;
import com.perficient.shoppingcart.ShoppingCart.repository.IUserRepository;
import com.perficient.shoppingcart.ShoppingCart.security.config.JwtService;
import com.perficient.shoppingcart.ShoppingCart.security.utils.AuthenticationRequest;
import com.perficient.shoppingcart.ShoppingCart.security.utils.AuthenticationResponse;
import com.perficient.shoppingcart.ShoppingCart.security.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        User user= User.builder()
                .firstName(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        iUserRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        var user = iUserRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
