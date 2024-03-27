package com.artragazzi.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public ResponseEntity<List<User>> findAll(){
        List<User>list = userService.findAll();
        return ResponseEntity.ok().body(list);
        
    }
    
}
