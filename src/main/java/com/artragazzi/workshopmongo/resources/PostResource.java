package com.artragazzi.workshopmongo.resources;

import com.artragazzi.workshopmongo.domain.Post;
import com.artragazzi.workshopmongo.domain.User;
import com.artragazzi.workshopmongo.dto.UserDTO;
import com.artragazzi.workshopmongo.resources.util.URL;
import com.artragazzi.workshopmongo.services.PostService;
import com.artragazzi.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")

public class PostResource {


    @Autowired
    private PostService postService;



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post>list = postService.findAll();
        return ResponseEntity.ok().body(list);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "")String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
