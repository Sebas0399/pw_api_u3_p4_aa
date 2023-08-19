package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthTokenFilter extends OncePerRequestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private JwtUtils jwtUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt=this.paseJwt(request);
        if(jwt!=null&&this.jwtUtils.validateJwtToken(jwt)){
            try{


            //Como es valido el token le voy a autenticar
            String nombre=this.jwtUtils.getUserNameFromJwtToken(jwt);
            //Le autenticamos
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(nombre,null,new ArrayList<>());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //Seteamos la autentiacion en la sesion
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            catch (Exception e){
                LOG.error("No se pudo realizar la autenticacion {}",e.getMessage());

            }
            filterChain.doFilter(request,response);

        }
    }
    private String paseJwt(HttpServletRequest request){
        String valorCompleto=request.getHeader("Authorization");
        if(StringUtils.hasText(valorCompleto)&&valorCompleto.startsWith("Bearer ")){
            return valorCompleto.substring(7);

        }
        return null;
    }
}
