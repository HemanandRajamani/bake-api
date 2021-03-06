package com.hems.controller;

import com.hems.models.AuthenticationRequest;
import com.hems.models.AuthenticationResponse;
import com.hems.models.User;
import com.hems.service.UserService;
import com.hems.utils.PBKDF2Encoder;
import com.hems.utils.TokenUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/auth")
public class LoginController {

    @Inject
    PBKDF2Encoder passwordEncoder;
    @Inject
    UserService userService;
    @Inject
    TokenUtils tokenUtils;

    @ConfigProperty(name = "com.hems.quarkusjwt.jwt.duration") public Long duration;
    @ConfigProperty(name = "mp.jwt.verify.issuer") public String issuer;

    @PermitAll
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(AuthenticationRequest authRequest) {
        User user = userService.findByUsername(authRequest.username);
        if (user != null && user.getPassword().equals(passwordEncoder.encode(authRequest.password))) {
            try {
                String token = tokenUtils.generateToken(user.getUsername(), user.getRoles(), duration, issuer);
                return Response.ok(AuthenticationResponse.builder().token(token).build()).build();
            } catch (Exception e) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
