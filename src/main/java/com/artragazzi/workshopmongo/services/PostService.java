package com.artragazzi.workshopmongo.services;

import com.artragazzi.workshopmongo.domain.Post;
import com.artragazzi.workshopmongo.domain.User;
import com.artragazzi.workshopmongo.dto.UserDTO;
import com.artragazzi.workshopmongo.repository.PostRepository;
import com.artragazzi.workshopmongo.repository.UserRepository;
import com.artragazzi.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepository;
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Object not found");
        }
        return post.get();
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date dateMin, Date dateMax){
        dateMax = new Date(dateMax.getTime() + 24*60*60*1000);
        return postRepository.fullSearch(text,dateMin,dateMax);
    }
}
