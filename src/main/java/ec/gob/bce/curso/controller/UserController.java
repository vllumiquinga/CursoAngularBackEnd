package ec.gob.bce.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.bce.curso.dto.UserDto;
import ec.gob.bce.curso.entidad.User;
import ec.gob.bce.curso.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAlluser() {
        return userService.findAll();
    }
    
    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User deleteUser) {
        userService.deleteUser(deleteUser);
    }
    
    @GetMapping("find/{userId}")
    public UserDto findUserById(@PathVariable("userId") Integer userId) {        
        return userService.findUserById(userId);                
    }
    
    @DeleteMapping("delete/{userIdDelete}")
    public UserDto deleteUserById(@PathVariable("userIdDelete") Integer userId) {    	
        return userService.deleteUserById(userId);
    }
    
    @PatchMapping("/update")
    public User updateUser(@RequestBody User updateUser) {
        userService.updateUser(updateUser);
        return updateUser;
    }
    
    
    
    
    
    
    

}
