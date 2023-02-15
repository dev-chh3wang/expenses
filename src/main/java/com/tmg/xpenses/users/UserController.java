package com.tmg.xpenses.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user/")
public class UserController {


    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> findUsers(){

        return new ResponseEntity<>(new UserDto(1,"Sara",1), HttpStatus.OK);
    }
    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAll(){
        List<User> all = userRepository.findAll();
        System.out.println(all.size());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
