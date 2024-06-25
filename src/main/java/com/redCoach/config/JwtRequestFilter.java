package com.redCoach.config;

import com.redCoach.entity.UserRegistration;
import com.redCoach.repository.UserRegistrationRepository;
import com.redCoach.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private UserRegistrationRepository userRegistrationRepository;
    private JwtService jwtService;

    public JwtRequestFilter(UserRegistrationRepository userRegistrationRepository, JwtService jwtService) {
        this.userRegistrationRepository = userRegistrationRepository;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
            String token = tokenHeader.substring(8,tokenHeader.length() - 1);
            String userName = jwtService.getUserName(token);
            Optional<UserRegistration> opUser = userRegistrationRepository.findByUserName(userName);
            if(opUser.isPresent()){
                UserRegistration user = opUser.get();
                //For server to understand who the current user is.
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user, null, Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
                );
                //asnwb
                authenticationToken.setDetails(new WebAuthenticationDetails(request));
                //sgs
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
