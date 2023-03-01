package com.tmg.xpenses.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user/")
public class UserController {


    UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        User user = new User(userDto.id(), userDto.name(), userDto.email());
        try{
            User saved = userService.save(user);
            return new ResponseEntity<>(UserDto.of(saved),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> findUsers(){

        return new ResponseEntity<>(new UserDto(1,"Sara","meil"), HttpStatus.OK);
    }



    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAll(){
        List<User> all = userService.findAll();
        System.out.println(all.size());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
