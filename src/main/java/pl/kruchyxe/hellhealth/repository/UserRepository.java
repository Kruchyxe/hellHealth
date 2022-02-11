package pl.kruchyxe.hellhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kruchyxe.hellhealth.model.User;

public interface UserRepository
        extends JpaRepository<User, Integer> {

}
