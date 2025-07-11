package ec.gob.bce.curso.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ec.gob.bce.curso.dao.UserRepository;
import ec.gob.bce.curso.dto.UserDto;
import ec.gob.bce.curso.entidad.User;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}
	
	public void deleteUser(User deleteUser) {
		userRepository.delete(deleteUser);
	}
	
	public void updateUser(User updateUser) {
		userRepository.saveAndFlush(updateUser);
	}
	
	public UserDto findUserById(Integer userId) {
		ModelMapper modelMapper = new ModelMapper();
		User userDb =userRepository.findById(userId).orElse(null);		
        return modelMapper.map(userDb, UserDto.class); 
	}
	
	public UserDto deleteUserById(Integer userId) {
		ModelMapper modelMapper = new ModelMapper();
		User userDb =userRepository.findById(userId).orElse(null);
		UserDto userDto = modelMapper.map(userDb, UserDto.class); 
		userRepository.deleteById(userId);
		return userDto;
	}

}
