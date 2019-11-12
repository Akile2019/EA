package edu.mum.cs.accountservice.controller;


import edu.mum.cs.accountservice.model.JwtAuthenticationRequest;
import edu.mum.cs.accountservice.model.JwtAuthenticationResponse;
import edu.mum.cs.accountservice.model.User;
import edu.mum.cs.accountservice.repository.UserRepo;
import edu.mum.cs.accountservice.config.JwtConfigurationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AccountController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtConfigurationUtility jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticateionToken
            (@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) throws Exception
    {
        authenticate(jwtAuthenticationRequest.getUseraccount(), jwtAuthenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthenticationRequest.getUseraccount());
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("User Not Approved :( ", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Not valid Credentials :( ", e);
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}