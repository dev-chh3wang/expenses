package com.tmg.xpenses.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user/")
public class UserController {



    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> findUsers(){
        return new ResponseEntity<>(new UserDto(1,"Sara",1), HttpStatus.OK);
    }
}
