package com.example.Travel_Guessing_Game.Component;
import com.example.Travel_Guessing_Game.Model.User;
import com.example.Travel_Guessing_Game.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();


        String token = request.getHeader("Authorization");


        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            System.out.println("Extracted Token: " + token);

            try {
                String username = jwtUtil.extractUsername(token);


                if (username != null && jwtUtil.validateToken(token, username)) {
                    Optional<User> user = userService.findByUsername(username);


                    if (user.isPresent()) {
                        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                                user.get().getUsername(),
                                user.get().getPassword(),
                                new ArrayList<>()
                        );

                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authToken);

                    }
                } else {
                    System.out.println("Invalid or Expired Token.");
                }
            } catch (Exception e) {
                System.out.println("Token Processing Error: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}

