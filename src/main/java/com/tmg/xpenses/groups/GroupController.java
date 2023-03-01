package com.tmg.xpenses.groups;

import com.tmg.xpenses.users.User;
import com.tmg.xpenses.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/group/")
public class GroupController {



    GroupService service;
    UserService userService;

    @Autowired
    public GroupController(GroupService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<GroupDto> get(@PathVariable Integer id){

        Optional<Group> byId = service.findById(id);
        if (byId.isPresent()) {
            return new ResponseEntity<>(new GroupDto(byId.get().getId(),byId.get().getName(),byId.get().getCreatedBy().getId().longValue()),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<GroupDto> create(@RequestBody GroupDto groupDto){
        try{
            Optional<User> user = userService.findById(groupDto.createdBy());
            Group save = service.save(new Group(groupDto.id(), groupDto.name(),user.get()));
          return new ResponseEntity<>(GroupDto.of(save), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try{
            service.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity<GroupDto> update(@RequestBody GroupDto group){
        try{
            Optional<User> byId = userService.findById(group.createdBy());
            Group updated = service.save(Group.of(group.id(), group.name(),byId.get()));
            return  new ResponseEntity<>(GroupDto.of(updated),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
