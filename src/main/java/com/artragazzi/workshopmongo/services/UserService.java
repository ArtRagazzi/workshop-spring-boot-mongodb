package com.artragazzi.workshopmongo.services;

import com.artragazzi.workshopmongo.domain.User;
import com.artragazzi.workshopmongo.dto.UserDTO;
import com.artragazzi.workshopmongo.repository.UserRepository;
import com.artragazzi.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();


    }
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user.get();
    }

    public User insert(User obj){

        return userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }
    public User update(User obj){
        Optional<User> OptionalnewObj = userRepository.findById(obj.getId());
        if(OptionalnewObj.isPresent()){
            User newObj = OptionalnewObj.get();
            updateData(newObj, obj);
            return userRepository.save(newObj);
        }else {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }

    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }


}
