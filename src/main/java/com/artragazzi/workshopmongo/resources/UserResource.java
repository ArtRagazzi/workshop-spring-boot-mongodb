package com.artragazzi.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.artragazzi.workshopmongo.dto.UserDTO;
import com.artragazzi.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.artragazzi.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")

public class UserResource {


    @Autowired
    private UserService userService;



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User>list = userService.findAll();
        List<UserDTO>listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
        
    }
    
}
