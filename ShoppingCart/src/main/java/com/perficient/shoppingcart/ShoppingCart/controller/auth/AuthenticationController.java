package com.perficient.shoppingcart.ShoppingCart.controller.auth;

import com.perficient.shoppingcart.ShoppingCart.security.utils.AuthenticationRequest;
import com.perficient.shoppingcart.ShoppingCart.security.utils.AuthenticationResponse;
import com.perficient.shoppingcart.ShoppingCart.security.utils.RegisterRequest;
import com.perficient.shoppingcart.ShoppingCart.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ShoppingCart/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(authenticationService.register(request)) ;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
