package br.net.mirante.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.net.mirante.entities.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long>{

	public AppUser findByLogin(String login);
}
