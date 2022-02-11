package pl.kruchyxe.hellhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kruchyxe.hellhealth.model.Customer;

public interface UserRepository
        extends JpaRepository<Customer, Integer> {

}
