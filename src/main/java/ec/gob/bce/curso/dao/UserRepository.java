package ec.gob.bce.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.bce.curso.entidad.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
