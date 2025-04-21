package com.app.authjwt.controller;

import com.app.authjwt.User.service.UserService;
import com.app.authjwt.payload.response.NoAuthResponse;
import com.app.authjwt.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VerifyService verifyService;

    @GetMapping("/info/profile")
    public Object infoProfile(Authentication authentication) {
        if (!hasPermission(authentication, "READ_PERMISSIONS") &&
                !hasPermission(authentication, "ADMIN_PERMISSIONS")) {
            return NoAuthResponse.builder()
                    .errorCode(HttpStatus.UNAUTHORIZED.value())
                    .Mensaje("USUARIO NO TIENE PERMISOS NECESARIOS")
                    .build();
        }
        return userService.getLoggedInUser();
    }

    private boolean hasPermission(Authentication auth, String permission) {
        return auth.getAuthorities().stream()
                .anyMatch(g -> g.getAuthority().equals(permission));
    }

//    @GetMapping("/all")
//    public Object AsignarRole(Authentication authentication) {
//        String[] requiredPermissions = {"ADMIN_PERMISSIONS"};
//        verifyService.verifyPermissions(requiredPermissions, authentication
//                , HttpStatus.UNAUTHORIZED.name());
//
//    }

    @GetMapping("/api/test-connection")
    public HttpStatus userAccess() {
        return HttpStatus.OK;
    }

}
