package twitt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import twitt.domain.TwUser;

public interface UserDao extends JpaRepository<TwUser, Long> {

}
