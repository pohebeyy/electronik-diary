package ru.dnevnik.pohebeyy.dnevnik.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dnevnik.pohebeyy.dnevnik.models.MyUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String username) ;
}
